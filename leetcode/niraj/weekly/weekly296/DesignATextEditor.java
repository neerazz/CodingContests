package weekly.weekly296;

/**
 * Created on:  Jun 04, 2022
 * Ref: https://leetcode.com/contest/weekly-contest-296/problems/design-a-text-editor/
 */

public class DesignATextEditor {

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor(); // The current text is "|". (The '|' character represents the cursor)
        textEditor.addText("leetcode"); // The current text is "leetcode|".
        System.out.println(textEditor.deleteText(4)); // return 4
        // The current text is "leet|".
        // 4 characters were deleted.
        textEditor.addText("practice"); // The current text is "leetpractice|".
        System.out.println(textEditor.cursorRight(3)); // return "etpractice"
        // The current text is "leetpractice|".
        // The cursor cannot be moved beyond the actual text and thus did not move.
        // "etpractice" is the last 10 characters to the left of the cursor.
        System.out.println(textEditor.cursorLeft(8)); // return "leet"
        // The current text is "leet|practice".
        // "leet" is the last min(10, 4) = 4 characters to the left of the cursor.
        System.out.println(textEditor.deleteText(10)); // return 4
        // The current text is "|practice".
        // Only 4 characters were deleted.
        System.out.println(textEditor.cursorLeft(2)); // return ""
        // The current text is "|practice".
        // The cursor cannot be moved beyond the actual text and thus did not move.
        // "" is the last min(10, 0) = 0 characters to the left of the cursor.
        System.out.println(textEditor.cursorRight(6)); // return "practi"
        // The current text is "practi|ce".
        // "practi" is the last min(10, 6) = 6 characters to the left of the cursor.

        textEditor = new TextEditor();
        System.out.println(textEditor.cursorRight(3));
        textEditor.addText("azizws");
        System.out.println(textEditor.cursorRight(3));
    }

    static class TextEditor {

        int position;
        StringBuilder string;

        public TextEditor() {
            position = 0;
            string = new StringBuilder();
        }

        public void addText(String text) {
            string.insert(position, text);
            position += text.length();
        }

        public int deleteText(int k) {
            int start = position - k, end = position;
            position -= k;
            if (start < 0) {
                start = 0;
                position = 0;
            }
            string.delete(start, end);
            return end - start;
        }

        public String cursorLeft(int k) {
            int newIdx = position - k;
            position = Math.max(newIdx, 0);
            if (position < 10) {
                return string.substring(0, position);
            } else {
                return string.substring(position - 10, position);
            }
        }

        public String cursorRight(int k) {
            int newIdx = position + k;
            position = Math.min(newIdx, string.length());
            if (position < 10) {
                return string.substring(0, position);
            } else {
                return string.substring(position - 10, position);
            }
        }
    }
}