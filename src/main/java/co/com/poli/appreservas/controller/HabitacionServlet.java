package co.com.poli.appreservas.controller;

import co.com.poli.appreservas.business.impl.HabitacionBusinessImpl;
import co.com.poli.appreservas.model.Habitacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cgaop
 */
public class HabitacionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        RequestDispatcher rd = null;

        HabitacionBusinessImpl hBusinessImpl = new HabitacionBusinessImpl();
        String accion = request.getParameter("accion");

        switch (accion) {
            case "crear":
                Boolean sw = false;

                String idHabitacion = request.getParameter("txtidhabitacion");
                int camas = Integer.getInteger(request.getParameter("txtcamas"));
                String tipoHabitacion = request.getParameter("txttipo");
                String banioPv = request.getParameter("txtprivado");

                Habitacion habitacion = new Habitacion(idHabitacion, tipoHabitacion, camas, banioPv);
                
                sw = hBusinessImpl.validarHabitacion(idHabitacion);

                if (sw == true) {
                    String msj = "Hola esta habitacion ya existe";
                    session.setAttribute("MENSAJE", msj);
                    rd = request.getRequestDispatcher("/mensaje.jsp");
                } else {
                    String msjCrear = hBusinessImpl.crearHabitacion(habitacion);
                    List<Habitacion> listaHabitaciones = hBusinessImpl.obtenerListaHabitaciones();
                    session.setAttribute("LISTADO", listaHabitaciones);
                    rd = request.getRequestDispatcher("/view/listaHabitaciones.jsp");
                }
                break;

            case "listar":
                List<Habitacion> listaHabitaciones = hBusinessImpl.obtenerListaHabitaciones();
                session.setAttribute("LISTADO", listaHabitaciones);
                rd = request.getRequestDispatcher("/view/listaHabitaciones.jsp");
                break;

//            case "usado":
//                String msjUsado = cBusinessImpl.creditoMasUsado();
//                session.setAttribute("MENSAJE", msjUsado);
//                rd = request.getRequestDispatcher("/mensaje.jsp");
//                break;
//
//            case "acumulado":
//                String msjAcumulado = cBusinessImpl.acumuladoCreditos();
//                session.setAttribute("MENSAJE", msjAcumulado);
//                rd = request.getRequestDispatcher("/mensaje.jsp");
//                break;
//
//            case "prestador":
//                String msjPrestador = cBusinessImpl.mayorPrestamista();
//                session.setAttribute("MENSAJE", msjPrestador);
//                rd = request.getRequestDispatcher("/mensaje.jsp");
//                break;
            default:
                break;
        }
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
