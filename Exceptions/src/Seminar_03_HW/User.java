package Seminar_03_HW;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class User {

    private String familyName;
    private String name;
    private String surname;
    private char gender;
    private long phoneNumber;
    private Date birthDay;

    public User() {

    }

    public String getFamilyName() {
        return familyName;
    }

    public void addData(String string) throws InputDateException {

        String phoneNumberRegex = "\\d{2,10}";
        String nameRegex = "[A-Za-zА-Яа-я]{3,20}";
        Pattern patternPhoneNumber = Pattern.compile(phoneNumberRegex);
        Pattern patternName = Pattern.compile(nameRegex);
        if (string.length() == 1) {
            if (this.gender != 0) {
                throw new InputDateException("Пол уже имеет значение, вы пытаетесь ввести его дважды.", string);
            }
            if (string.equals("f")  || string.equals("m")) {
                this.gender = string.charAt(0);
            } else {
                throw new InputDateException("Неправильно указан пол.", string);
            }
        } else if (string.indexOf(".") != -1) {
            if (this.birthDay != null) {
                throw new InputDateException("День рождения пользователя уже заполнен.", string);
            }try {
                this.birthDay = new Date(string);
            }catch (DateException e){
                throw new InputDateException("Дата введена неверно.\n" + e.getMessage(),string);
            }

        } else if (patternPhoneNumber.matcher(string).matches()) {
            if (this.phoneNumber != 0) {
                throw new InputDateException("Номер телефона уже добавлен.", string);
            }else if (string.length() < 10){
                throw new InputDateException("Некорректный номер телефона",string);
            }
            this.phoneNumber = Long.parseLong(string);
        } else if (patternName.matcher(string).matches()) {
            if (this.familyName == null) {
                this.familyName = string;
            } else if (this.name == null) {
                this.name = string;
            } else if (this.surname == null) {
                this.surname = string;
            } else {
                throw new InputDateException("ФИО уже заполнен.", string);
            }
        } else {
            throw new InputDateException("Вы ввели что-то странное", string);
        }
    }
    @Override
    public String toString() {
        return String.format("<%s><%s><%s><%s><%d><%s>",familyName,name,surname,birthDay,phoneNumber,gender);
    }
}
