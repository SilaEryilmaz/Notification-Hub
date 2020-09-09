package Language;

public class English implements ILanguage{
    @Override
    public String printErrorMessage() {
        return "The bill has not been paid for two months..." +
                "\n You are being BLACKLISTED ! ";
    }
}
