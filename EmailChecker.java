package Essentials;

import java.util.regex.*;

public class EmailChecker
{
    private static final String[] VALID_DOMAINS = {
            "gmail.com", "yahoo.com", "outlook.com", "rediffmail.com",
            "icloud.com", "mailchimp.com", "zoho.com", "gmx.com",
            "tutanota.com", "aol.com", "yandex.com", "protonmail.com",
            "fastmail.com", "hey.com", "mail.com", "hushmail.com",
            "mailfence.com", "runbox.com", "zohomail.com", "mail.ru"
    };

    public static boolean checkEmail(String emailId)
    {
        if (!emailId.contains("@")) {
            return false;
        }

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9~!$%^&*_=+}{'?-.]+@[a-zA-Z0-9.-]+$");
        Matcher matcher = pattern.matcher(emailId);
        if (!matcher.matches()) {
            return false;
        }

        emailId = emailId.trim().toLowerCase();
        String endChecker = emailId.substring(emailId.lastIndexOf('@') + 1);

        for (String domain : VALID_DOMAINS) {
            if (endChecker.equals(domain)) {
                return true;
            }
        }
        return false;
    }
}
