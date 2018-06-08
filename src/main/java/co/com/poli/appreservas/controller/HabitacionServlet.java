package co.com.poli.appreservas.controller;

import co.com.poli.appreservas.business.impl.HabitacionBusinessImpl;
import co.com.poli.appreservas.model.Habitacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
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
                Boolean sw2 = false;

                String idHabitacion = request.getParameter("txtidhabitacion");
                String camas = request.getParameter("txtcamas");
                String tipoHabitacion = request.getParameter("txttipo");
                String banioPv = request.getParameter("txtprivado");

                int camasI = Integer.parseInt(camas);

                Habitacion habitacion = new Habitacion(idHabitacion, tipoHabitacion, camasI, banioPv);

                sw = hBusinessImpl.validarHabitacion(idHabitacion);//true=noCrear(existe)
                sw2 = hBusinessImpl.validarCamas(tipoHabitacion, camasI);//true=noCrear(camasErr)

                if (sw == true) {//habitacionExiste
                    String msj = "Hola esta habitacion ya existe";
                    session.setAttribute("MENSAJE", msj);
                    msj = "";
                    rd = request.getRequestDispatcher("/mensaje.jsp");

                } else if (sw2 == true) {//camasErr
                    String msj = "Hola ...";
                    msj = msj + " esta habitacion no acepta este numero de camas";

                    if (tipoHabitacion.equalsIgnoreCase("compartida")) {
                        msj = msj + "\n rango aceptado -> 4 a 8 camas para habitacion compartida";
                    } else if (tipoHabitacion.equalsIgnoreCase("privada")) {
                        msj = msj + "\n solo aceptan 4 camas para habitacion privada";
                    }

                    session.setAttribute("MENSAJE", msj);
                    msj = "";
                    rd = request.getRequestDispatcher("/mensaje.jsp");

                } else {//habitacion no existe... crear
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
