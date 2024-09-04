package com.epam.java.basics.module_8_nested_classes.task_1_contact_book;

public class Contact {
    private String contactName;

    private final int MAX_EMAIL_ADDRESS = 3;
    private final int MAX_SOCIAL_MEDIA = 5;

    private int currentIndexEmails;
    private int currentIndexSocialMedia;

    ContactInfo[] emailsArray;
    ContactInfo[] socialMediaArray;
    ContactInfo phoneNumber;

    private boolean hasPhoneNumber;

    public Contact(String contactName) {
        this.contactName = contactName;

        this.currentIndexEmails = 0;
        this.currentIndexSocialMedia = 0;

        this.emailsArray = new ContactInfo[MAX_EMAIL_ADDRESS];
        this.socialMediaArray = new ContactInfo[MAX_SOCIAL_MEDIA];

        this.hasPhoneNumber = false;
    }

    private class NameContactInfo implements ContactInfo {

        @Override
        public String getTitle() {
            return "Name";
        }

        @Override
        public String getValue() {
            return contactName;
        }
    }

    public static class Email implements ContactInfo {
        private String localPart;
        private String domain;

        @Override
        public String getTitle() {
            return "Email";
        }

        @Override
        public String getValue() {
            return localPart + "@" + domain;
        }
    }

    public static class Social implements ContactInfo {
        private String title;
        private String id;

        public String setTitle(String title) {
            this.title = title;
            return title;
        }

        public String setId(String id) {
            this.id = id;
            return id;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getValue() {
            return id;
        }
    }

    public void rename(String newName) {
        if (newName != null && !newName.isEmpty()) {
            contactName = newName;
        }
    }

    public ContactInfo[] getInfo() {
        int totalInfoCount = 1 + (phoneNumber != null ? 1 : 0) + currentIndexEmails + currentIndexSocialMedia;
        ContactInfo[] result = new ContactInfo[totalInfoCount];

        int index = 0;
        result[index++] = new NameContactInfo();

        if (phoneNumber != null) {
            result[index++] = phoneNumber;
        }

        for (int i = 0; i < currentIndexEmails; i++) {
            result[index++] = emailsArray[i];
        }

        for (int i = 0; i < currentIndexSocialMedia; i++) {
            result[index++] = socialMediaArray[i];
        }

        return result;
    }

    public Email addEmail(String localPart, String domain) {
        if (currentIndexEmails == MAX_EMAIL_ADDRESS) {
            return null;
        }

        Email email = new Email();
        email.localPart = localPart;
        email.domain = domain;

        emailsArray[currentIndexEmails] = email;
        currentIndexEmails++;

        return email;
    }

    public Email addEpamEmail(String firstname, String lastname) {
        if (currentIndexEmails == MAX_EMAIL_ADDRESS) {
            return null;
        }

        Email email = new Email() {
            final String firstPart = firstname;
            final String secondPart = lastname;

            @Override
            public String getTitle(){
                return "Epam Email";
            }

            @Override
            public String getValue(){
                return firstPart + "_" + secondPart + "@epam.com";
            }
        };
        emailsArray[currentIndexEmails] = email;
        currentIndexEmails++;

        return email;
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        if (hasPhoneNumber) {
            return null;
        }

        ContactInfo contactInfo = new ContactInfo() {
            @Override
            public String getTitle() {
                return "Tel";
            }

            @Override
            public String getValue() {
                return "+" + code + " " + number;
            }
        };

        hasPhoneNumber = true;
        return phoneNumber = contactInfo;
    }

    public Social addTwitter(String twitterId) {
        if (currentIndexSocialMedia == MAX_SOCIAL_MEDIA) {
            return null;
        }

        Social social = new Social() {
            @Override
            public String getTitle() {
                return "Twitter";
            }

            @Override
            public String getValue() {
                return twitterId;
            }
        };
        socialMediaArray[currentIndexSocialMedia] = social;
        currentIndexSocialMedia++;

        return social;
    }

    public Social addInstagram(String instagramId) {
        if (currentIndexSocialMedia == MAX_SOCIAL_MEDIA) {
            return null;
        }

        Social social = new Social() {
            @Override
            public String getTitle() {
                return "Instagram";
            }

            @Override
            public String getValue() {
                return instagramId;
            }
        };
        socialMediaArray[currentIndexSocialMedia] = social;
        currentIndexSocialMedia++;

        return social;
    }

    public Social addSocialMedia(String title, String id) {
        if (currentIndexSocialMedia == MAX_SOCIAL_MEDIA) {
            return null;
        }

        Social social = new Social() {
            @Override
            public String getTitle() {
                return setTitle(title);
            }

            @Override
            public String getValue() {
                return setId(id);
            }
        };
        socialMediaArray[currentIndexSocialMedia] = social;
        currentIndexSocialMedia++;

        return social;
    }
}