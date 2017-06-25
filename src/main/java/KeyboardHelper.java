import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;


public class KeyboardHelper {

    public static ReplyKeyboardMarkup createReplyKeyboard(List<String> buttons, boolean oneTime ) {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setOneTimeKeyboard(oneTime);
        List<KeyboardRow> grid = new ArrayList<>();
        for (String btn : buttons) {
            KeyboardRow row = new KeyboardRow();
            KeyboardButton ibtn = new KeyboardButton();
            ibtn.setText(btn);
            row.add(ibtn);
            grid.add(row);
        }

        markup.setKeyboard(grid);
        return markup;
    }

    public static ReplyKeyboardRemove createRemoveReplyKeyboard(){
        return new ReplyKeyboardRemove();
    }

}
