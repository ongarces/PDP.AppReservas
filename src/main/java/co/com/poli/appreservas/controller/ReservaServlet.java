package co.com.poli.appreservas.controller;

import co.com.poli.appreservas.business.impl.HabitacionBusinessImpl;
import co.com.poli.appreservas.business.impl.ReservaBusinessImpl;
import co.com.poli.appreservas.model.Habitacion;
import co.com.poli.appreservas.model.Reserva;

import java.io.IOException;
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
public class ReservaServlet extends HttpServlet {

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

        ReservaBusinessImpl rBusinessImpl = new ReservaBusinessImpl();
        HabitacionBusinessImpl hBusinessImpl = new HabitacionBusinessImpl();

        String accion = request.getParameter("accion");

        switch (accion) {
            case "crear":
                Boolean sw = false;
                Boolean sw2 = false;
                Boolean sw3 = false;

                String idReserva = request.getParameter("txtidreserva");
                String idHabitacionR = request.getParameter("txthabitacion");
                String camas = request.getParameter("txtcamas");

                int camasI = Integer.parseInt(camas);
                int precioCama = 0;

                sw = hBusinessImpl.validarHabitacion(idHabitacionR);//true=(Habitacion.existe)
                sw2 = rBusinessImpl.validarReserva(idReserva);//true=(Reserva.existe)

                if (sw == true && sw2 == false) {//habitacion existe - reserva no existe

                    //obtener la habitacionRegistrada - NO RESERVADA
                    Habitacion habitacionR = hBusinessImpl.obtenerHabitacion(idHabitacionR);

                    if (habitacionR.getTipoHabitacion().equalsIgnoreCase("privada")) {              //PV                                           
                        sw3 = rBusinessImpl.validarReservaPrivada(idHabitacionR);//true=existe  

                        if (sw3 == true) { //privada - reservada
                            String msj = "Hola esta habitacion PRIVADA ya esta reservada";
                            session.setAttribute("MENSAJE", msj);
                            msj = "";
                            rd = request.getRequestDispatcher("/mensaje.jsp");
                        } else if (camasI > 4 || camasI < 1) { //privada - camas > 4
                            String msj = "Hola esta habitacion solo permite hasta 4 camas";
                            session.setAttribute("MENSAJE", msj);
                            msj = "";
                            rd = request.getRequestDispatcher("/mensaje.jsp");
                        } else {  //privada - disponible para crear     
                            camasI = 4;
                            precioCama = 50000;
                            //Reserva cumple... --> crear
                            Reserva reservacion = new Reserva(idReserva, idHabitacionR, camasI, precioCama);
                            String msjCrear = rBusinessImpl.crearReserva(reservacion);

                            List<Reserva> listaReservas = rBusinessImpl.obtenerListaReservas();
                            session.setAttribute("LISTADO", listaReservas);
                            session.setAttribute("MENSAJE", msjCrear);

                            rd = request.getRequestDispatcher("/view/listaReservas.jsp");
                        }
                    } else if (habitacionR.getTipoHabitacion().equalsIgnoreCase("compartida")) {    //COMPARTIDA

                        if (camasI <= habitacionR.getCamasHabitacion()) { //CUMPLE solicitud camas <= camas Habitacion

                            int libres = 0, ocupadas = 0;
                            ocupadas = rBusinessImpl.buscarOcupadas(idHabitacionR);
                            libres = habitacionR.getCamasHabitacion() - ocupadas;

                            if (libres < camasI) { //camas insuficientes
                                String msj = "Hola esta habitacion COMPARTIDA no cumple con el numero de camas disponibles";
                                session.setAttribute("MENSAJE", msj);
                                msj = "";

                                rd = request.getRequestDispatcher("/mensaje.jsp");
                            } else { //camas suficientes
                                libres = libres - camasI;
                                ocupadas = ocupadas + camasI;
                                precioCama = 30000;

                                Reserva reservacion = new Reserva(idReserva, idHabitacionR, camasI, precioCama);
                                String msjCrear = rBusinessImpl.crearReserva(reservacion);

                                List<Reserva> listaReservas = rBusinessImpl.obtenerListaReservas();
                                session.setAttribute("LISTADO", listaReservas);
                                session.setAttribute("MENSAJE", msjCrear);

                                rd = request.getRequestDispatcher("/view/listaReservas.jsp");

                            }

                        } else { //no cumple solicitud con camas de habitacion
                            String msj = "Hola esta habitacion solo permite reservar hasta 8 camas cuando estan disponibles";
                            session.setAttribute("MENSAJE", msj);
                            msj = "";
                            rd = request.getRequestDispatcher("/mensaje.jsp");
                        }
                    }
                } else if(sw == false){//habitacion no existe
                    String msj = "Hola ha ocurrido un error la HABITACION NO EXISTE";
                    session.setAttribute("MENSAJE", msj);
                    msj = "";
                    rd = request.getRequestDispatcher("/mensaje.jsp");
                }else if (sw2 == true){//reserva existe
                    String msj = "Hola ha ocurrido un error la RESERVA YA EXISTE";
                    session.setAttribute("MENSAJE", msj);
                    msj = "";
                    rd = request.getRequestDispatcher("/mensaje.jsp");
                }
                /*
                //Reserva cumple... --> crear
                Reserva reservacion = new Reserva(idReserva, idHabitacionR, camasI, precioCama);
                String msjCrear = rBusinessImpl.crearReserva(reservacion);
                List<Reserva> listaReservas = rBusinessImpl.obtenerListaReservas();
                session.setAttribute("LISTADO", listaReservas);
                rd = request.getRequestDispatcher("/view/listaReservas.jsp");
                 */

//                Boolean sw = false;
//                Boolean sw2 = false;
//
//                String idHabitacion = request.getParameter("txtidhabitacion");
//                String camas = request.getParameter("txtcamas");
//                String tipoHabitacion = request.getParameter("txttipo");
//                String banioPv = request.getParameter("txtprivado");
//
//                int camasI = Integer.parseInt(camas);
//
//                Habitacion habitacion = new Habitacion(idHabitacion, tipoHabitacion, camasI, banioPv);
//
//                sw = hBusinessImpl.validarHabitacion(idHabitacion);//true=noCrear(existe)
//                sw2 = hBusinessImpl.validarCamas(tipoHabitacion, camasI);//true=noCrear(camasErr)
//
//                if (sw == true) {//ReservaExiste
//                    String msj = "Hola esta habitacion ya existe";
//                    session.setAttribute("MENSAJE", msj);
//                    msj = "";
//                    rd = request.getRequestDispatcher("/mensaje.jsp");
//
//                } else if (sw2 == true) {//camasErr
//                    String msj = "Hola ...";
//                    msj = msj + " esta habitacion no acepta este numero de camas";
//
//                    if (tipoHabitacion.equalsIgnoreCase("compartida")) {
//                        msj = msj + "\n rango aceptado -> 4 a 8 camas para habitacion compartida";
//                    } else if (tipoHabitacion.equalsIgnoreCase("privada")) {
//                        msj = msj + "\n solo aceptan 4 camas para habitacion privada";
//                    }
//
//                    session.setAttribute("MENSAJE", msj);
//                    msj = "";
//                    rd = request.getRequestDispatcher("/mensaje.jsp");
//
//                } else {//Reserva no existe... --> crear
//                    String msjCrear = hBusinessImpl.crearHabitacion(habitacion);
//                    List<Habitacion> listaHabitaciones = hBusinessImpl.obtenerListaHabitaciones();
//                    session.setAttribute("LISTADO", listaHabitaciones);
//                    rd = request.getRequestDispatcher("/view/listaHabitaciones.jsp");
//                }
                break;

            case "listar":

                List<Reserva> listarReservas = rBusinessImpl.obtenerListaReservas();
                session.setAttribute("LISTADO", listarReservas);
//                
//                List<Habitacion> listaHabitaciones = hBusinessImpl.obtenerListaHabitaciones();
//                session.setAttribute("LISTADO2", listaHabitaciones);

                rd = request.getRequestDispatcher("/view/listaReservas.jsp");
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
