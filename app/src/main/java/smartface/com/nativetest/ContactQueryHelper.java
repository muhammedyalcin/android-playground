package smartface.com.nativetest;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

public class ContactQueryHelper {

    public static String[] getStructuredName(Context context, Uri contactUri) {
        String id = getContactId(context, contactUri);
        String[] selectionArgs = new String[]{ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE, id};

        Cursor cursor = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, null,
                ContactsContract.Data.MIMETYPE + " = ? AND " + ContactsContract.CommonDataKinds.StructuredName.CONTACT_ID + " = ?", selectionArgs, null);

        String[] nameStructure = null;
        if (cursor != null && cursor.moveToFirst()) {
            int firstNameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME);
            int familyIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredName.FAMILY_NAME);
            int nPrefixIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredName.PREFIX);
            int mNameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredName.MIDDLE_NAME);
            int nSuffixIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredName.SUFFIX);

            String firstName = firstNameIndex != -1 ? cursor.getString(firstNameIndex) : null;
            String familyName = familyIndex != -1 ? cursor.getString(familyIndex) : null;
            String nPrefix = nPrefixIndex != -1 ? cursor.getString(nPrefixIndex) : null;
            String nName = mNameIndex != -1 ? cursor.getString(mNameIndex) : null;
            String nSuffix = nSuffixIndex != -1 ? cursor.getString(nSuffixIndex) : null;

            nameStructure = new String[]{firstName, familyName, nPrefix, nName, nSuffix};
        }

        cursor.close();

        return nameStructure;
    }

    public static String[] getUrlAddresses(Context context, String id) {
        final String[] projection = new String[]{
                ContactsContract.CommonDataKinds.Website.URL
        };
        String selection = ContactsContract.Data.CONTACT_ID + " = " + id + " AND " + ContactsContract.Contacts.Data.MIMETYPE + " = '" + ContactsContract.CommonDataKinds.Website.CONTENT_ITEM_TYPE + "'";

        final Cursor contactData = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, projection, selection, null, null);

        List<String> urlAddresses = null;
        if (contactData.moveToFirst()) {
            urlAddresses = new ArrayList<>();
            do {
                int urlAddressesIndex = contactData.getColumnIndex(ContactsContract.CommonDataKinds.Website.URL);

                if (urlAddressesIndex != -1) {
                    String urlAddress = contactData.getString(urlAddressesIndex);
                    urlAddresses.add(urlAddress);
                }

            } while (contactData.moveToNext());
        }
        contactData.close();

        //List to array ?
        return urlAddresses != null ? urlAddresses.toArray(new String[urlAddresses.size()]) : null;
    }

    public static String[] getContactDataById(Context context, Uri contactUri, String[] projection, String[] selectionArgs) {
        Cursor contentCursor = context.getContentResolver().query(contactUri, projection, ContactsContract.Data.CONTACT_ID + " = ?", selectionArgs, null);

        List<String> data = null;
        if (contentCursor != null && contentCursor.getCount() > 0) {
            contentCursor.moveToFirst();
            do {
                int columnIndex = contentCursor.getColumnIndex("data1");
                if (columnIndex != -1) {
                    data.add(contentCursor.getString(columnIndex));
                }
            } while (contentCursor.moveToFirst());
        }
        return data != null ? data.toArray(new String[data.size()]) : null;
    }

    public static String getContactId(Context context, Uri contactUri) {
        Cursor idCursor = context.getContentResolver().query(contactUri, new String[]{ContactsContract.Contacts._ID},
                null, null, null);
        if (!idCursor.moveToFirst()) {
            idCursor.close();
            return null;
        }
        String id = idCursor.getString(idCursor.getColumnIndex(ContactsContract.Contacts._ID));
        idCursor.close();
        return id;
    }

    public static String[] getEmailAddresses(Context context, String id) {
        final String[] projection = {ContactsContract.CommonDataKinds.Website.URL};
        String selection = ContactsContract.Data.CONTACT_ID + " = " + id + " AND " + ContactsContract.Contacts.Data.MIMETYPE + " = '" + ContactsContract.CommonDataKinds.Website.CONTENT_ITEM_TYPE + "'";


        final Cursor eAddressesCursor = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, projection, selection, null, null);

        String[] eAddresses = null;
        if (eAddressesCursor.moveToFirst()) {
            eAddresses = new String[eAddressesCursor.getCount()];
            int count = 0;
            do {
                int eAddressesIndex = eAddressesCursor.getColumnIndex(ContactsContract.CommonDataKinds.Website.URL);

                if (eAddressesIndex != -1) {
                    String address = eAddressesCursor.getString(eAddressesIndex);
                    eAddresses[count++] = address;
                }

            } while (eAddressesCursor.moveToNext());
        }
        eAddressesCursor.close();

        return eAddresses;
    }

    public static String[] getPhoneNumbers(Context context, String id) {

        final String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};
        String selection = ContactsContract.Data.CONTACT_ID + " = " + id;

        final Cursor phoneNumberCursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, projection, selection, null, null);

        String[] phoneNumbers = null;
        if (phoneNumberCursor.moveToFirst()) {
            phoneNumbers = new String[phoneNumberCursor.getCount()];
            int count = 0;
            do {
                int phoneNumerIndex = phoneNumberCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);

                if (phoneNumerIndex != -1) {
                    String phoneNumber = phoneNumberCursor.getString(phoneNumerIndex);
                    phoneNumbers[count++] = phoneNumber;
                }

            } while (phoneNumberCursor.moveToNext());
        }
        phoneNumberCursor.close();

        return phoneNumbers;
    }

    public static String[] getAddresses(Context context, String id) {

        final String[] projection = {ContactsContract.CommonDataKinds.StructuredPostal.FORMATTED_ADDRESS};
        String selection = ContactsContract.Data.CONTACT_ID + " = " + id;

        final Cursor addressesCursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_URI, projection, selection, null, null);

        String[] addresses = null;
        if (addressesCursor.moveToFirst()) {
            addresses = new String[addressesCursor.getCount()];
            int count = 0;
            do {
                int addressesIndex = addressesCursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.FORMATTED_ADDRESS);

                if (addressesIndex != -1) {
                    String address = addressesCursor.getString(addressesIndex);
                    addresses[count++] = address;
                }

            } while (addressesCursor.moveToNext());
        }
        addressesCursor.close();

        return addresses;
    }


    public static String[] getWorkById(Context context, String id) {
        final String[] projection = {ContactsContract.CommonDataKinds.Organization.COMPANY, ContactsContract.CommonDataKinds.Organization.TITLE};

        String selection = ContactsContract.Data.CONTACT_ID + " = " + id + " AND " + ContactsContract.Contacts.Data.MIMETYPE + " = '" + ContactsContract.CommonDataKinds.Organization.CONTENT_ITEM_TYPE + "'";


        final Cursor workCursor = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, projection,
                selection, null, null);

        String[] work = null;
        if (workCursor.moveToFirst()) {
            int titleIndex = workCursor.getColumnIndex(ContactsContract.CommonDataKinds.Organization.TITLE);
            int organizationIndex = workCursor.getColumnIndex(ContactsContract.CommonDataKinds.Organization.COMPANY);

            String title = titleIndex != -1 ? workCursor.getString(titleIndex) : null;
            String organization = organizationIndex != -1 ? workCursor.getString(organizationIndex) : null;

            System.out.println(" title " + title + " " + organization);
        }
        workCursor.close();

        return work;
    }

}
