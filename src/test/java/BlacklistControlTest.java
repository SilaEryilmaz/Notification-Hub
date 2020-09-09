import Language.English;
import Model.*;
import Pricing.FixedQuotaEmailPricing;
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

public class BlacklistControlTest {

    @Test
    public void it_should_add_company_to_blacklist_when_not_paying_the_bill_for_two_months(){
        //CREATE COMPANY
        CompanyDTO company1 = new CompanyDTO();
        company1.setCompanyName("Kodluyoruz");

        LocalDate registrationDate = LocalDate.of(2020, Month.APRIL, 06);
        company1.setRegistrationDate(registrationDate);
        company1.setLanguage(new English());

        //SET THE INVOICE INFORMATION
        BillDTO billDTO = new BillDTO();
        Queue<Double> allFees = new LinkedList<>();
        billDTO.setAllFees(allFees);
        billDTO.setPayingCompany(company1);


        //CREATE PEOPLE THAT WILL RECEIVE NOTIFICATIONS
        PersonDTO person1 = new PersonDTO();
        person1.setPersonName("Sila");
        person1.setPersonSurname("Eryilmaz");
        person1.setPhoneNumber("05077780056");
        person1.setPersonEmail("slaeryilmaz3@gmail.com");



        //MAKE A GROUP WITH THAT PEOPLE
        GroupDTO group1 = new GroupDTO();
        List<PersonDTO> notGroup1 = new ArrayList<PersonDTO>();
        group1.setNotificationGroup(notGroup1);
        notGroup1.add(person1);
        for(int i=0; i<5; i++) {
            notGroup1.add(person1);
        }

        //CREATE NOTIFICATION
        NotificationDTO notification1 = new NotificationDTO();
        notification1.setCompanySender(company1);
        notification1.setReceiverGroup(group1);
        notification1.setText("HEY! IT'S A TRIAL NOTIFICATION");
        LocalDate notificationDate = LocalDate.of(2020, Month.MAY, 06);
        notification1.setNotificationDate(notificationDate);

        //Create BlackList
        BlacklistDTO blackList = new BlacklistDTO();
        List<CompanyDTO> restirectedCompany = new ArrayList<CompanyDTO>();
        blackList.setCompanyBlackList(restirectedCompany);

        //CHOOSE PACKAGE FOR SENDING NOTIFICATION
        DateDifference dateDifference = new DateDifference(notificationDate,registrationDate);
        company1.setPackageUsageDays(dateDifference.findDifferenceBetweenDates());
        List<IPackage> packages=new ArrayList<IPackage>();
        packages.add(new FixedQuotaEmailSender(new PayingBillsValidation()));

        SenderService senderService = new SenderService(packages);
        senderService.sendNotification(blackList,notification1);


        //PRICING METHODS
        List<IPackagePricing> fees = new ArrayList<IPackagePricing>();
        fees.add(new FixedQuotaEmailPricing());
        PricingService pricingService = new PricingService(fees);
        pricingService.feeCalculation(billDTO);

        // MONTHLY PRICING
        FeeReportingService feeReportingService = new FeeReportingService();
        feeReportingService.printBillFees(billDTO);

        NotificationDTO notification2 = new NotificationDTO();
        notification2.setCompanySender(company1);
        notification2.setReceiverGroup(group1);
        notification2.setText("HEY! IT'S A TRIAL NOTIFICATION");
        LocalDate notificationDate2 = LocalDate.of(2020, Month.JUNE, 05);
        notification2.setNotificationDate(notificationDate2);

        DateDifference dateDifference2 = new DateDifference(notificationDate2, notificationDate);
        company1.setPackageUsageDays(dateDifference2.findDifferenceBetweenDates());
        List<IPackage> packages2=new ArrayList<IPackage>();
        packages2.add(new FixedQuotaEmailSender(new PayingBillsValidation()));

        SenderService senderService2 = new SenderService(packages2);
        senderService2.sendNotification(blackList,notification2);


        //PRICING METHODS
        List<IPackagePricing> fees2 = new ArrayList<IPackagePricing>();
        fees2.add(new FixedQuotaEmailPricing());
        PricingService pricingService2 = new PricingService(fees2);
        pricingService2.feeCalculation(billDTO);

        // MONTHLY PRICING
        FeeReportingService feeReportingService2 = new FeeReportingService();
        feeReportingService2.printBillFees(billDTO);



        blackList.addToBlackList(billDTO);


        NotificationDTO notification3 = new NotificationDTO();
        notification3.setCompanySender(company1);
        notification3.setReceiverGroup(group1);
        notification3.setText("HEY! IT'S A TRIAL NOTIFICATION");
        LocalDate notificationDate3 = LocalDate.of(2020, Month.JULY, 05);
        notification2.setNotificationDate(notificationDate3);


        DateDifference dateDifference3 = new DateDifference(notificationDate3, notificationDate2);
        company1.setPackageUsageDays(dateDifference3.findDifferenceBetweenDates());
        List<IPackage> packages3=new ArrayList<IPackage>();
        packages3.add(new FixedQuotaEmailSender(new PayingBillsValidation()));
        packages3.add(new FlexibleQuotaSmsSender(new PayingBillsValidation()));

        SenderService senderService3 = new SenderService(packages3);
        senderService2.sendNotification(blackList,notification3);










    }


    }




