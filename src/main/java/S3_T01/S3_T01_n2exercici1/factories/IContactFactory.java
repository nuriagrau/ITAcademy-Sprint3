package S3_T01.S3_T01_n2exercici1.factories;

import S3_T01.S3_T01_n2exercici1.address.IAddress;
import S3_T01.S3_T01_n2exercici1.phoneNumber.IPhoneNumber;

public interface IContactFactory {

    abstract IAddress createAddress(String[] addressData);

    abstract IPhoneNumber createPhoneNumber(String phoneNumber);

}
