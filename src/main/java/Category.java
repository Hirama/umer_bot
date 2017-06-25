public enum Category {
    Pensioner("Пенсионер"),
    Unemployed("Неработающий"),
    Child("Ребенок"),
    Employed("Работающий");

    private String name;
    Category(String name) {
        this.name = name;
    }

    public static Category switchType(String text){
        switch (text){
            case "Пенсионер":
                return Pensioner;
            case "Неработающий":
                return Unemployed;
            case "Ребенок":
                return Child;
            case "Работающий":
                return Employed;
            default:
                return null;
        }
    }
}
