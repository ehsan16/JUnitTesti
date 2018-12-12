package javaweb.part1.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javaweb.part1.dao.ArtistDao;

import javaweb.part1.model.Artist;


/**
 * Servlet implementation class ArtistListServlet
 */
@WebServlet("/artists")
public class ArtistListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ArtistListServlet() {
		super();
	}
       private ArtistDao artistDao = new ArtistDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			try {
				
				List<Artist> artists = artistDao.findAllArtists();
				
				
				request.setAttribute("artists", artists);
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/artist.jsp");
			dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
