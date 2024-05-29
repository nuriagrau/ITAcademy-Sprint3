package S3_T01.S3_T01_n2exercici1.factories;


import S3_T01.S3_T01_n2exercici1.address.DKAddress;
import S3_T01.S3_T01_n2exercici1.phoneNumber.IPhoneNumber;
import S3_T01.S3_T01_n2exercici1.address.IAddress;
import S3_T01.S3_T01_n2exercici1.phoneNumber.DKPhoneNumber;

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
