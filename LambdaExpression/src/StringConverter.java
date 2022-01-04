public class StringConverter {
    public static void run() {
        Converter uppercaseConverter = (String s) -> (s.toUpperCase());
        String upperString = uppercaseConverter.apply("Hello World!");
        System.out.println(upperString);

        Converter lowercaseConverter = (String s) -> (s.toLowerCase());
        String lowerString = lowercaseConverter.apply("Hello World!");
        System.out.println(lowerString);

        Converter titleCaseConverter = (String s) -> {
            StringBuilder sb = new StringBuilder();
            boolean nextTitleCase = true;

            for(char c : s.toCharArray()) {
                if(Character.isSpaceChar(c)) {
                    nextTitleCase = true;
                } else if(nextTitleCase) {
                    c = Character.toTitleCase(c);
                    nextTitleCase = false;
                }
                sb.append(c);
            }

            return sb.toString();
        };

        String titleCaseString = titleCaseConverter.apply("java the complete reference");
        System.out.println(titleCaseString);

    }
}
