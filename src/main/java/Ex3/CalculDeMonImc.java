package Ex3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CalculDeMonImc")
public class CalculDeMonImc extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CalculDeMonImc() {
        super();
    }

    private void calculer(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String poidsParam = request.getParameter("poids");
        String tailleParam = request.getParameter("taille");

        double poids = Double.parseDouble(poidsParam);
        double taille = Double.parseDouble(tailleParam);


        Imc imcObj = new Imc(taille, poids);
        double imc = imcObj.calcul();

        out.println("<html><body>");
        out.println("<h1>Résultat IMC</h1>");
        out.println("<p>Votre IMC est : " + imc + "</p>");
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        calculer(request, response);
    }

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        calculer(request, response);
    }
}
