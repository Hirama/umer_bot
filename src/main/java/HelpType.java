public enum HelpType {
    GetPaid("Получить выплату"),
    BuryFree("Похоронить бесплатно");

    private String name;
    HelpType(String name){
        this.name = name;
    }

    public static HelpType switchType(String text){
        switch (text){
            case "Получить выплату":
                return GetPaid;
            case "Похоронить бесплатно":
                return BuryFree;
            default:
                return null;
        }
    }
}
