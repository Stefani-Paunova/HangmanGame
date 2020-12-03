package hangman.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hangmanBuisnessLogic.Game;
import org.hangmanBuisnessLogic.GameService;
import org.springframework.context.ApplicationContext;



@WebServlet("/games")
public class StartGameServlet extends HttpServlet {
	
	public GameService gameService;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		gameService =  ((ApplicationContext) config.getServletContext().getAttribute(AppCtxListener.SPTING_CTX_NAME)).getBean(GameService.class);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		Game game  = gameService.getGameById(id);
		String lives = gameService.printLives(game.getId());
		
		
			if(gameService.checkForWinning(id)) {
			req.setAttribute("win", "win");
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		}else if(game.getLives() == 0) {
			req.setAttribute("originalWord", game.getOriginalWord());
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		}else {
			req.setAttribute("game", game);
			req.setAttribute("lives", lives);
			req.setAttribute("letters", game.getLetters());
			RequestDispatcher rd = req.getRequestDispatcher("gamePage.jsp");
			rd.forward(req, resp);
		}
		
			
			
		
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Game game;
		int id = 0;
		char l;
		if(req.getParameter("id") != null) {
			
			id = Integer.parseInt(req.getParameter("id"));
			game = gameService.getGameById(id);
			l =  req.getParameter("letter").charAt(0);
			game = gameService.setLetter(l, id);
		}else {

			game = gameService.createGame();
		}
		
	
		resp.sendRedirect(req.getContextPath() + "games?id="+ game.getId());
		
	
		
		
	}

	
	
}

