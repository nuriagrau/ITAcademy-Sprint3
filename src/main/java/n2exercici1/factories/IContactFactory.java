package n2exercici1.factories;

import n2exercici1.address.IAddress;
import n2exercici1.phoneNumber.IPhoneNumber;

public interface IContactFactory {

    abstract IAddress createAddress(String[] addressData);

    abstract IPhoneNumber createPhoneNumber(String phoneNumber);

}
