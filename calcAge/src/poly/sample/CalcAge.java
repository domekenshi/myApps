package poly.sample;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CalcAgeLogic;
import model.UserInfo;

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

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        //index.htmlからの入力値を取得
        String name = request.getParameter("name");
        String userYear = request.getParameter("year");
        String userMonth = request.getParameter("month");
        String userDay =request.getParameter("day");

        //UserInfoクラスのインスタンス生成
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setYear(Integer.parseInt(userYear));
        userInfo.setMonth(Integer.parseInt(userMonth));
        userInfo.setDay(Integer.parseInt(userDay));
        //年齢計算のクラスのインスタンスの生成と実行
        CalcAgeLogic calcAgeLogic = new CalcAgeLogic();
        calcAgeLogic.execute(userInfo);

        //リクエストスコープに保存
        request.setAttribute("UserInfo", userInfo);
        //ビューへのフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
        dispatcher.forward(request, response);

    }

}
