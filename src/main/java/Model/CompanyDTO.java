package Model;

import Language.ILanguage;
import java.time.LocalDate;

public class CompanyDTO {

    private String companyName;
    private LocalDate registrationDate;
    private ILanguage language;

    private double fixedQuotaSmsCount;
    private double flexibleQuotaSmsCount;
    private double fixedQuotaEmailCount;
    private double flexibleQuotaEmailCount;
    private long packageUsageDays;

    public ILanguage getLanguage() {
        return language;
    }

    public void setLanguage(ILanguage language) {
        this.language = language;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public double getFixedQuotaSmsCount() {
        return fixedQuotaSmsCount;
    }

    public void setFixedQuotaSmsCount(double fixedQuotaSmsCount) {
        this.fixedQuotaSmsCount = fixedQuotaSmsCount;
    }

    public double getFlexibleQuotaSmsCount() {
        return flexibleQuotaSmsCount;
    }

    public void setFlexibleQuotaSmsCount(double flexibleQuotaSmsCount) {
        this.flexibleQuotaSmsCount = flexibleQuotaSmsCount;
    }

    public double getFixedQuotaEmailCount() {
        return fixedQuotaEmailCount;
    }

    public void setFixedQuotaEmailCount(double fixedQuotaEmailCount) {
        this.fixedQuotaEmailCount = fixedQuotaEmailCount;
    }

    public double getFlexibleQuotaEmailCount() {
        return flexibleQuotaEmailCount;
    }

    public void setFlexibleQuotaEmailCount(double flexibleQuotaEmailCount) {
        this.flexibleQuotaEmailCount = flexibleQuotaEmailCount;
    }

    public long getPackageUsageDays() {
        return packageUsageDays;
    }

    public void setPackageUsageDays(long packageUsageDays) {
        this.packageUsageDays = packageUsageDays;
    }

    public void increaseFixedQuotaSmsCount(){
        fixedQuotaSmsCount++;
    }

    public void increaseFlexibleQuotaSmsCount(){
        flexibleQuotaSmsCount++;
    }

    public void increaseFixedQuotaEmailCount(){
        fixedQuotaEmailCount++;
    }

    public void increaseFlexibleQuotaEmailCount(){
        flexibleQuotaEmailCount++;
    }


}

