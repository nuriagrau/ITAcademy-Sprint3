package S3_T01.S3_T01_n2exercici1;

import S3_T01.S3_T01_n2exercici1.address.IAddress;
import S3_T01.S3_T01_n2exercici1.factories.DKContactFactory;
import S3_T01.S3_T01_n2exercici1.factories.ESContactFactory;
import S3_T01.S3_T01_n2exercici1.factories.IContactFactory;
import S3_T01.S3_T01_n2exercici1.factories.UKContactFactory;
import S3_T01.S3_T01_n2exercici1.phoneNumber.IPhoneNumber;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AppTools {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Contact> AddressBook = new ArrayList<>();


    public static void displayMenu() {
        int option;
        String name;
        int contactIndex;
        String country;
        IContactFactory contactFactory = null;

        do {
            option = inputInt(""" 
                    Select an option: 
                    0. Exit
                    1. Create contact
                    2. Show contact
                    3. Delete contact
                    4. List AddressBook
                    """);

            switch (option) {
                case 0:
                    System.out.println("Aloha!");
                    break;
                case 1:
                    name = inputString("Enter contact name: ");
                    String[] addressData = requestAddressData();
                    country = addressData[7];

                    String phoneNumber = requestPhoneData(country);
                    if (country.equalsIgnoreCase("Denmark")) {
                        contactFactory = new DKContactFactory();
                    } else if (country.equalsIgnoreCase("Spain")) {
                        contactFactory = new ESContactFactory();
                    } else if (country.equalsIgnoreCase("United Kingdom")) {
                        contactFactory = new UKContactFactory();
                    } else {
                        System.out.println("Error! This country AddressBook has not been created.");
                    }
                    IAddress newAddress = contactFactory.createAddress(addressData);
                    IPhoneNumber newPhoneNumber = contactFactory.createPhoneNumber(phoneNumber);
                    AddressBook.add(new Contact(name, country, newAddress, newPhoneNumber));
                    break;
                case 2:
                    if (AddressBook.size() > 0) {
                        System.out.println(listAddressBookNames());
                        do {
                            name = inputString("Enter name of contact to show");
                            contactIndex = getContactIndex(name);
                            if (contactIndex != -1) {
                                System.out.println(AddressBook.get(contactIndex).toString());
                            } else {
                                System.out.println("This contact does not exist.");
                            }
                        } while (contactIndex == -1);
                    } else {
                        System.out.println("The Address Book is empty.");
                    }
                    break;
                case 3:
                    if (AddressBook.size() > 0) {
                        System.out.println(listAddressBookNames());
                        do {
                            name = inputString("Enter the name of the contact to delete: ");
                            contactIndex = getContactIndex(name);
                            if (contactIndex != -1) {
                                AddressBook.remove(contactIndex);
                                System.out.println("The contact of " + name + " has been deleted.");
                            } else {
                                System.out.println("This contact does not exist.");
                            }
                        } while (contactIndex == -1);
                    } else {
                        System.out.println("The Address Book is empty.");
                    }
                    break;
                case 4:
                    if (AddressBook.size() > 0) {
                        AddressBook.sort(
                                (Contact c1, Contact c2) -> c1.compareTo(c2));
                        for (Contact c: AddressBook) {
                            System.out.println(c.toString());
                        }
                    } else {
                        System.out.println("The address book is empty.");
                    }
                    break;
            }
        } while (option != 0);
    }


    public static String[] requestAddressData() {
        String street, streetNumber, floorNumber, doorNumber, postCode, cityTown, province, country;
        boolean found = false;
        street = inputString("Street name: ");
        streetNumber = inputString("Street number: ");
        floorNumber = (inputBoolean("Floor number (true or false)? "))? inputString("Floor number: ") : "";
        doorNumber = (inputBoolean("Door number (true or false)? "))? inputString("Door number: "): "" ;
        cityTown = inputString("City or Town: ");
        province = inputString("County or province: ");
        do {
            country = inputString("Country (Denmark, Spain, United Kingdom): ");
            found = Country.findByValue(country);
        } while (!found);
        postCode = requestPostCode(country);
        return new String[] {street, streetNumber, floorNumber, doorNumber, cityTown, province, postCode, country};
    }

    public static String requestPostCode(String country) {
        String postCode, regexPostCode = null;
        boolean matches;
        do {
            postCode = inputString("Post Code: ");
            regexPostCode = Country.valueOfRegexPostCode(country);
            Pattern pattern = Pattern.compile(regexPostCode);
            matches = pattern
                    .matcher(postCode)
                    .matches();
        } while(!matches);
        return postCode;
    }

    public static String requestPhoneData(String country) {
        String phoneNumber, regexPhone = null;
        boolean matches;
        do {
            phoneNumber = inputString("Phone number without country code: ");
            regexPhone = Country.valueOfRegexPhoneNumber(country);
            Pattern pattern = Pattern.compile(regexPhone);
            matches = pattern
                    .matcher(phoneNumber)
                    .matches();
        } while(!matches);
        return phoneNumber;
    }


    public static int inputInt(String request) {
        int input = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.println(request);
            try {
                input = scanner.nextInt();
                isValid = true;
            } catch (InputMismatchException e) {
                System.err.println("Format Error. Please enter a valid integer.");
            } finally {
                scanner.nextLine();
            }
        }
        return input;
    }

    public static String inputString(String missatge) {
        Boolean isValid = false;
        String userInput = "";
        do {
            try {
                System.out.println(missatge);
                userInput = scanner.nextLine();
                isValid = true;
            } catch (Exception e) {
                System.out.println("Format Error. Introduce a String.");
            }
        } while (!isValid || userInput.length() == 0);
        return userInput;

    }

    public static boolean inputBoolean(String request) {
        boolean input = false;
        boolean isValid = false;
        while (!isValid) {
            System.out.println(request);
            try {
                input = scanner.nextBoolean();
                isValid = true;
            } catch (InputMismatchException e) {
                System.err.println("Format Error. Please enter true or false.");
            } finally {
                scanner.nextLine();
            }
        }
        return input;
    }

    public static int getContactIndex(String name) {
        boolean found = false;
        int addressIndex = -1;
        if (AddressBook.size() > 0 && !found) {
            for (int i = 0; i < AddressBook.size(); i++) {
                if (AddressBook.get(i).getName().equalsIgnoreCase(name)) {
                    addressIndex = i;
                    found = true;
                }
            }

        }
        return addressIndex;
    }

    public static String listAddressBookNames() {
        String message = "The names in the Address Book are:\n";
        for (Contact c : AddressBook) {
            message += c.getName() + "\n";
        }
        return message;
    }
}
