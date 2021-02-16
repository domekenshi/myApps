package poly.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcAge
 */
@WebServlet("/CalcAge")
public class CalcAge extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcAge() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

//        int year = 1987;
//        int birthday = year;
//        String name = "中村 まさと";
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
//        int thisYear = Integer.parseInt(sdf.format(date));
//        int userAge = thisYear - birthday;
//
//        response.setContentType("text/html; charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>年齢計算</title>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<hr>");
//        out.println("<p>ユーザー名：" + name + "</p>");
//        out.println("<p>生まれた西暦：" + birthday + "</p>");
//        out.println("<hr>");
//
//        out.println("<p>あなたの年齢は今年「" + userAge + "」です</p>");
//        out.println("</body>");
//        out.println("</html>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
//        doGet(request, response);
        request.setCharacterEncoding("UTF-8");
        // HTMLから値の取得
        String name = request.getParameter("name");
        String userYear = request.getParameter("year");
        String userMonth = request.getParameter("month");
        String userDay = request.getParameter("day");

        // 今年の日付を取得
        LocalDateTime ldf = LocalDateTime.now();
        int thisYear = ldf.getYear();
        int thisMonth = ldf.getMonthValue();
        int thisDay = ldf.getDayOfMonth();
        // メッセージとユーザーの年齢の初期化と宣言
        String msg = "";
        int userAge = 0;
        // ユーザーの生年月日をint型に変換
        int birthYear = Integer.parseInt(userYear);
        int birthMonth = Integer.parseInt(userMonth);
        int birthDay = Integer.parseInt(userDay);

        // 取得した値に応じて計算式を分ける
        if (thisMonth < birthMonth || (thisMonth == birthMonth && thisDay > birthDay)) {
            userAge = thisYear - birthYear - 1;
        } else if (thisMonth > birthMonth || (thisMonth == birthMonth && thisDay >= birthDay)) {
            userAge = thisYear - birthYear;
        }

        msg = name + "さんの年齢は" + userAge + "です。";

        // HTMLに出力
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>年齢計算アプリ</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>" + msg + "</p>");
        out.println("</body>");
        out.println("</html>");

    }

}
