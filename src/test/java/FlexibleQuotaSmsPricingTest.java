import Model.*;
import Pricing.FixedQuotaEmailPricing;
import Pricing.FlexibleQuotaSmsPricing;
import Pricing.IPackagePricing;
import SenderMethods.FixedQuotaEmailSender;
import SenderMethods.FlexibleQuotaSmsSender;
import SenderMethods.IPackage;
import Service.FeeReportingService;
import Service.PricingService;
import Service.SenderService;
import Validation.PayingBillsValidation;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FlexibleQuotaSmsPricingTest {

    @Test
    public void it_should_calculate_flexibleQuotaSms() {

        //CREATE COMPANY
        CompanyDTO company1 = new CompanyDTO();
        company1.setCompanyName("Trendyol Tech");
        LocalDate registrationDate = LocalDate.of(2020, Month.SEPTEMBER, 06);
        company1.setRegistrationDate(registrationDate);


        //CREATE PEOPLE THAT WILL RECEIVE NOTIFICATIONS
        PersonDTO person1 = new PersonDTO();
        person1.setPersonName("Sila");
        person1.setPersonSurname("Eryilmaz");
        person1.setPhoneNumber("05077780056");
        person1.setPersonEmail("slaeryilmaz3@gmail.com");

        PersonDTO person2 = new PersonDTO();
        person2.setPersonName("Seyma");
        person2.setPersonSurname("Sozen");
        person2.setPhoneNumber("05324615656");
        person2.setPersonEmail("seysozen@gmail.com");

        //MAKE A GROUP WITH THAT PEOPLE
        GroupDTO group1 = new GroupDTO();
        List<PersonDTO> notGroup1 = new ArrayList<PersonDTO>();
        group1.setNotificationGroup(notGroup1);
        notGroup1.add(person1);
        notGroup1.add(person2);

        //CREATE NOTIFICATION
        NotificationDTO notification1 = new NotificationDTO();
        notification1.setCompanySender(company1);
        notification1.setReceiverGroup(group1);
        notification1.setText("HEY! IT'S A TRIAL NOTIFICATION");
        LocalDate notificationDate = LocalDate.of(2020, Month.OCTOBER, 06);
        company1.setRegistrationDate(notificationDate);



        //Create BlackList
        BlacklistDTO blackList = new BlacklistDTO();
        List<CompanyDTO> restirectedCompany = new ArrayList<CompanyDTO>();
        blackList.setCompanyBlackList(restirectedCompany);

        //CHOOSE PACKAGE FOR SENDING NOTIFICATION
        DateDifference dateDifference = new DateDifference(notificationDate,registrationDate);
        company1.setPackageUsageDays(dateDifference.findDifferenceBetweenDates());
        List<IPackage> packages = new ArrayList<IPackage>();
        packages.add(new FlexibleQuotaSmsSender(new PayingBillsValidation()));
        SenderService senderService = new SenderService(packages);
        senderService.sendNotification(blackList, notification1);


        //SET THE INVOICE INFORMATION
        BillDTO billDTO = new BillDTO();
        Queue<Double> allFees = new LinkedList<>();
        billDTO.setAllFees(allFees);
        billDTO.setPayingCompany(company1);


        //PRICING METHODS
        List<IPackagePricing> fees = new ArrayList<IPackagePricing>();
        fees.add(new FlexibleQuotaSmsPricing());
        PricingService pricingService = new PricingService(fees);
        pricingService.feeCalculation(billDTO);

        // MONTHLY PRICING
        FeeReportingService chargingReports = new FeeReportingService();
        chargingReports.printBillFees(billDTO);


    }
}