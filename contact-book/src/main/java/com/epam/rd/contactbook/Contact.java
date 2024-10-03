package com.epam.rd.contactbook;


import java.util.Arrays;


public class Contact {
    private String contactName;
    private ContactInfo phoneNumber;
    private Email[] emails = new Email[3];
    private Social[] socials = new Social[5];
    private int currentEmailIndex = 0;
    private int currentSocialIndex = 0;
    private ContactInfo[] info = new ContactInfo[9];
    private int currentInfoIndex = 0;

    public Contact(String contactName) {
        this.contactName = contactName;
    }

    public static class Email implements ContactInfo {
        private String localPart;
        private String domain;
        public static final String EPAMDOMAIN = "epam.com";

        public Email(String localPart, String domain) {
            this.localPart = localPart;
            this.domain = domain;
        }

        @Override
        public String getTitle() {
            return "Email";
        }

        @Override
        public String getValue() {
            return localPart + "@" + domain;
        }
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

    public static class Social implements ContactInfo {
        private String title;
        private String id;
        public static final String TWITTER = "Twitter";
        public static final String INSTAGRAM = "Instagram";

        public Social(String title, String id) {
            this.title = title;
            this.id = id;
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
            this.contactName = newName;
        }
    }

    public Email addEmail(String localPart, String domain) {
        if (currentEmailIndex < emails.length) {
            Email email = new Email(localPart, domain);
            emails[currentEmailIndex] = email;
            currentEmailIndex++;
            return email;
        }
        return null;
    }

    public Email addEpamEmail(String firstname, String lastname) {
        if (currentEmailIndex < emails.length) {
            String name = String.format("%s_%s", firstname, lastname);
            Email email = new Email(name, Email.EPAMDOMAIN) {
                @Override
                public String getTitle() {
                    return "Epam Email";
                }
            };

            emails[currentEmailIndex] = email;
            currentEmailIndex++;
            return email;
        }
        return null;
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        if (this.phoneNumber != null) {
            return null;
        }
        ContactInfo phone = new ContactInfo() {
            @Override
            public String getTitle() {
                return "Tel";
            }

            @Override
            public String getValue() {
                return String.format("+%d %s", code, number);
            }
        };
        this.phoneNumber = phone;
        return phone;
    }

    public Social addTwitter(String twitterId) {
        return addSocialMedia(Social.TWITTER, twitterId);
    }

    public Social addInstagram(String instagramId) {
        return addSocialMedia(Social.INSTAGRAM, instagramId);
    }

    public Social addSocialMedia(String title, String id) {
        if (currentSocialIndex < socials.length) {
            Social social = new Social(title, id);
            socials[currentSocialIndex] = social;
            currentSocialIndex++;
            return social;
        }
        return null;
    }

    public ContactInfo[] getInfo() {
        currentInfoIndex = 0;

        info[currentInfoIndex] = new NameContactInfo();
        currentInfoIndex++;


        if (phoneNumber != null) {
            info[currentInfoIndex] = phoneNumber;
            currentInfoIndex++;
        }


        for (Email email : emails) {
            if (email != null) {
                info[currentInfoIndex] = email;
                currentInfoIndex++;
            }
        }


        for (Social social : socials) {
            if (social != null) {
                info[currentInfoIndex] = social;
                currentInfoIndex++;
            }
        }

        return Arrays.copyOf(info, currentInfoIndex);
    }
}
