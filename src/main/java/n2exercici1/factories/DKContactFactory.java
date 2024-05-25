package n2exercici1.factories;


import n2exercici1.address.DKAddress;
import n2exercici1.address.IAddress;
import n2exercici1.phoneNumber.DKPhoneNumber;
import n2exercici1.phoneNumber.IPhoneNumber;

public class DKContactFactory implements IContactFactory {

    @Override
    public IAddress createAddress(String[] addressData) {
        return new DKAddress(addressData[0],addressData[1], addressData[2], addressData[3], addressData[4], addressData[5],addressData[6]);
    }

    @Override
    public IPhoneNumber createPhoneNumber(String phoneNumber) {
        return new DKPhoneNumber(phoneNumber);
    }
}
