package javaweb.part1.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaweb.part1.dao.AlbumDao;
import javaweb.part1.model.Album;


@WebServlet("/AlbumiLista")
public class AlbumiLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AlbumiLista() {
        super();
       
    }
    private AlbumDao albumDao = new AlbumDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Album> albums = albumDao.findAllAlbums();
			request.setAttribute("albums", albums);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/album.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
