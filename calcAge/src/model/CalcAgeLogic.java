package model;

import java.time.LocalDateTime;

public class CalcAgeLogic {
    public void execute(UserInfo userInfo) {
        // 今年の日付の取得
        LocalDateTime ldf = LocalDateTime.now();
        int thisYear = ldf.getYear();
        int thisMonth = ldf.getMonthValue();
        int thisDay = ldf.getDayOfMonth();

        // 自分の生年月日、名前を取得
        int birthYear = userInfo.getYear();
        int birthMonth = userInfo.getMonth();
        int birthDay = userInfo.getDay();
        String name = userInfo.getName();
        // メッセージと年齢の変数の定義
        String msg = "";
        int userAge = 0;

        //年齢を計算する条件式
        if (thisMonth < birthMonth || (thisMonth == birthMonth && thisDay > birthDay)) {
            userAge = thisYear - birthYear - 1;
        } else if (thisMonth > birthMonth || (thisMonth == birthMonth && thisDay >= birthDay)) {
            userAge = thisYear - birthYear;
        }

        msg = name + "さんの年齢は" + userAge + "です。";
        //メッセージをJavaBeansに保存
        userInfo.setMsg(msg);
    }
}
