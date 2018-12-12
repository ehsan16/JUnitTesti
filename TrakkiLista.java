package javaweb.part1.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javaweb.part1.dao.TrackDao;

import javaweb.part1.model.Track;

/**
 * Servlet implementation class TrakkiLista
 */
@WebServlet("/TrakkiLista")
public class TrakkiLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public TrakkiLista() {
        super();
        // TODO Auto-generated constructor stub
    }
    private TrackDao trackDao = new TrackDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			List<Track> tracks = trackDao.findAllTracks();
			
			
			request.setAttribute("tracks", tracks);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/track.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
