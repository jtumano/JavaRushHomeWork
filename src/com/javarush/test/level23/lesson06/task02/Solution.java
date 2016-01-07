package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {
    public static final class Constants {
        public static final String C1 = "Server is not accessible for now.";
        public static final String C2 = "User is not authorized.";
        public static final String C3 = "User is banned.";
        public static final String C4 = "Access is denied.";
    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.C1);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.C1, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.C2);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.C2, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.C3);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.C3, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.C4);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.C4, cause);
        }
    }
}
