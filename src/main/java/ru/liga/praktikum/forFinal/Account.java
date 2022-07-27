package ru.liga.praktikum.forFinal;
public class Account {

    private final String name;
    private final char c = ' ';
    private final int notFound = -1;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        if ((name.length()<3) | (name.length()>19) | (name.indexOf(c)==notFound)) // проверка на длину строки и наличие в ней хотя бы 1 пробела
            return false;
//        name = name.trim();
//        System.out.print("trim= \""+name+"\", ");
        int i = name.trim().indexOf(c);
//        System.out.print("i=" + i);
        //пробел не в начале и/или конце строки и единственный
        return (i != notFound) & (name.indexOf(c, i + 1) == notFound);
    }

}