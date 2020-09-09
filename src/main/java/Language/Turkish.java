package Language;

public class Turkish implements ILanguage{
    @Override
    public String printErrorMessage() {
        return "Fatura iki aydir odenmedi! " +
                "\n Blacklist'e Alındınız!!! ";
    }
}
