package com.epam.java.basics.module_8_nested_classes.task_1_contact_book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void testRegularPositiveScenario() {
        Contact contact = new Contact("William the Conqueror");

        contact.addEmail("william", "normandy.fr");
        contact.addEmail("william", "england.travel");

        contact.addEpamEmail("william", "conqueror");

        contact.addTwitter("@william1066");
        contact.addInstagram("@bayeux_tapestry");
        contact.addSocialMedia("Facebook", "la_manche_tours");

        contact.addPhoneNumber(44, "20-1066-1087");

        ContactInfo[] info = contact.getInfo();

        assertEquals("Name: William the Conqueror", toString(info[0]));
        assertEquals("Tel: +44 20-1066-1087", toString(info[1]));

        assertEquals("Email: william@normandy.fr", toString(info[2]));
        assertEquals("Email: william@england.travel", toString(info[3]));
        assertEquals("Epam Email: william_conqueror@epam.com", toString(info[4]));

        assertEquals("Twitter: @william1066", toString(info[5]));
        assertEquals("Instagram: @bayeux_tapestry", toString(info[6]));
        assertEquals("Facebook: la_manche_tours", toString(info[7]));

        assertEquals(info.length, 8);
    }

    @Test
    void testRegularPositiveScenarioShuffleAddition() {
        Contact contact = new Contact("William the Conqueror");
        contact.addTwitter("@william1066");

        contact.addEmail("william", "normandy.fr");
        contact.addInstagram("@bayeux_tapestry");
        contact.addEmail("william", "england.travel");
        contact.addPhoneNumber(44, "20-1066-1087");
        contact.addSocialMedia("Facebook", "la_manche_tours");
        contact.addEpamEmail("william", "conqueror");

        ContactInfo[] info = contact.getInfo();

        assertEquals("Name: William the Conqueror", toString(info[0]));
        assertEquals("Tel: +44 20-1066-1087", toString(info[1]));

        assertEquals("Email: william@normandy.fr", toString(info[2]));
        assertEquals("Email: william@england.travel", toString(info[3]));
        assertEquals("Epam Email: william_conqueror@epam.com", toString(info[4]));

        assertEquals("Twitter: @william1066", toString(info[5]));
        assertEquals("Instagram: @bayeux_tapestry", toString(info[6]));
        assertEquals("Facebook: la_manche_tours", toString(info[7]));

        assertEquals(info.length, 8);
    }

    @Test
    void testJustEmailsScenario() {
        Contact contact = new Contact("William the Conqueror");

        contact.addEmail("william", "normandy.fr");
        contact.addEmail("william", "england.travel");

        contact.addEpamEmail("william", "conqueror");

        ContactInfo[] info = contact.getInfo();

        assertEquals("Name: William the Conqueror", toString(info[0]));

        assertEquals("Email: william@normandy.fr", toString(info[1]));
        assertEquals("Email: william@england.travel", toString(info[2]));
        assertEquals("Epam Email: william_conqueror@epam.com", toString(info[3]));

        assertEquals(info.length, 4);

    }

    @Test
    void testEmailLimits() {
        Contact contact = new Contact("William the Conqueror");

        Contact.Email email1 = contact.addEmail("william", "normandy.fr");
        Contact.Email email2 = contact.addEmail("william", "england.travel");
        Contact.Email email3 = contact.addEmail("william", "gmail.com");
        Contact.Email email4 = contact.addEmail("william", "epam.com");

        assertNotNull(email1);
        assertNotNull(email2);
        assertNotNull(email3);
        assertNull(email4);

        ContactInfo[] info = contact.getInfo();

        assertEquals("Name: William the Conqueror", toString(info[0]));

        assertEquals("Email: william@normandy.fr", toString(info[1]));
        assertEquals("Email: william@england.travel", toString(info[2]));
        assertEquals("Email: william@gmail.com", toString(info[3]));

        assertEquals(4, info.length);
    }

    @Test
    void testEmailLimitsWithEpamEmails() {
        Contact contact = new Contact("William the Conqueror");

        Contact.Email email1 = contact.addEpamEmail("william", "legitimate");
        Contact.Email email2 = contact.addEmail("william", "normandy.fr");
        Contact.Email email3 = contact.addEpamEmail("william", "conqueror");

        Contact.Email email4 = contact.addEmail("william", "england.travel");
        Contact.Email email5 = contact.addEpamEmail("william", "of_normandy");

        assertNotNull(email1);
        assertNotNull(email2);
        assertNotNull(email3);
        assertNull(email4);
        assertNull(email5);

        ContactInfo[] info = contact.getInfo();

        assertEquals("Name: William the Conqueror", toString(info[0]));

        assertEquals("Epam Email: william_legitimate@epam.com", toString(info[1]));
        assertEquals("Email: william@normandy.fr", toString(info[2]));
        assertEquals("Epam Email: william_conqueror@epam.com", toString(info[3]));

        assertEquals(4, info.length);
    }

    @Test
    void testEpamEmailIsSubClassOfEmail() {
        Contact contact = new Contact("William the Conqueror");

        Contact.Email email1 = contact.addEpamEmail("william", "legitimate");
        Contact.Email email2 = contact.addEmail("william", "normandy.fr");

        assertNotEquals(Contact.Email.class, email1.getClass());
        assertTrue(true);

        assertEquals(Contact.Email.class, email2.getClass());

        assertEquals(contact.getInfo().length, 3);

    }

    @Test
    void testTelLimits() {
        Contact contact = new Contact("William the Conqueror");

        ContactInfo tel1 = contact.addPhoneNumber(33, "276-1066-555");
        ContactInfo tel2 = contact.addPhoneNumber(44, "20-1066-5555");
        ContactInfo tel3 = contact.addPhoneNumber(33, "55-1066-5555");

        assertNotNull(tel1);
        assertNull(tel2);
        assertNull(tel3);

        ContactInfo[] info = contact.getInfo();

        assertEquals("Name: William the Conqueror", toString(info[0]));
        assertEquals("Tel: +33 276-1066-555", toString(info[1]));

        assertEquals(2, info.length);
    }

    @Test
    void testRename() {
        Contact contact = new Contact("William the Legitimate Heir");
        ContactInfo nameInfo = contact.getInfo()[0];

        assertEquals("Name: William the Legitimate Heir", toString(nameInfo));

        contact.rename(null);
        assertEquals("Name: William the Legitimate Heir", toString(nameInfo));

        contact.rename("");
        assertEquals("Name: William the Legitimate Heir", toString(nameInfo));

        contact.rename("William the Conqueror");
        assertEquals("Name: William the Conqueror", toString(nameInfo));

        assertEquals(1, contact.getInfo().length);
    }

    @Test
    void testSocialMediaLimits() {
        Contact contact = new Contact("William the Conqueror");

        Contact.Social social1 = contact.addTwitter("@william1066");
        Contact.Social social2 = contact.addInstagram("@bayeux_tapestry");
        Contact.Social social3 = contact.addSocialMedia("Facebook", "la_manche_tours");
        Contact.Social social4 = contact.addSocialMedia("Facebook", "doomsday_book");
        Contact.Social social5 = contact.addSocialMedia("Reddit", "r/cavalry_aesthetics");
        Contact.Social social6 = contact.addSocialMedia("Facebook", "british cuisine");
        Contact.Social social7 = contact.addSocialMedia("Facebook", "la_manche_tours");
        Contact.Social social8 = contact.addTwitter("@william1028");
        Contact.Social social9 = contact.addInstagram("@penny_coins_art");

        assertNotNull(social1);
        assertNotNull(social2);
        assertNotNull(social3);
        assertNotNull(social4);
        assertNotNull(social5);
        assertNull(social6);
        assertNull(social7);
        assertNull(social8);
        assertNull(social9);

        ContactInfo[] info = contact.getInfo();

        assertEquals("Name: William the Conqueror", toString(info[0]));
        assertEquals("Twitter: @william1066", toString(info[1]));
        assertEquals("Instagram: @bayeux_tapestry", toString(info[2]));
        assertEquals("Facebook: la_manche_tours", toString(info[3]));
        assertEquals("Facebook: doomsday_book", toString(info[4]));
        assertEquals("Reddit: r/cavalry_aesthetics", toString(info[5]));

        assertEquals(6, contact.getInfo().length);
    }

    @Test
    void testSocialMediaLimitsNoTwitter() {
        Contact contact = getContact();

        ContactInfo[] info = contact.getInfo();

        assertEquals("Name: William the Conqueror", toString(info[0]));
        assertEquals("Instagram: @bayeux_tapestry", toString(info[1]));
        assertEquals("Facebook: la_manche_tours", toString(info[2]));
        assertEquals("Instagram: @penny_coins_art", toString(info[3]));
        assertEquals("Facebook: doomsday_book", toString(info[4]));
        assertEquals("Reddit: r/cavalry_aesthetics", toString(info[5]));

        assertEquals(6, contact.getInfo().length);
    }

    private static Contact getContact() {
        Contact contact = new Contact("William the Conqueror");

        contact.addInstagram("@bayeux_tapestry");
        contact.addSocialMedia("Facebook", "la_manche_tours");
        contact.addInstagram("@penny_coins_art");
        contact.addSocialMedia("Facebook", "doomsday_book");
        contact.addSocialMedia("Reddit", "r/cavalry_aesthetics");
        contact.addSocialMedia("Facebook", "british cuisine");
        contact.addSocialMedia("Facebook", "la_manche_tours");
        contact.addTwitter("@william1028");
        contact.addTwitter("@william1066");
        return contact;
    }


    private static String toString(ContactInfo info) {
        return info.getTitle() + ": " + info.getValue();
    }
}