package it.alessandro.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.alessandro.mvc.controllers.BaseController;
import it.alessandro.mvc.controllers.Destination;
import it.alessandro.mvc.controllers.FornitoreController;
import it.alessandro.mvc.controllers.ProdottoController;
import it.alessandro.mvc.model.FornitoreDAO;
import it.alessandro.mvc.model.ProdottoDAO;




@WebServlet("*.doi")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String path = request.getRequestURI();
		int slash = path.lastIndexOf('/');
		String action = path.substring(slash + 1, path.length() - 4);
		Destination destination = null;
		
		try {
			switch (action.toLowerCase()) {
			case "archiviofornitori": {
				FornitoreController controller = new FornitoreController(new FornitoreDAO());
				destination = controller.listaFornitori(request, response);
			}
				break;
			case "archivioprodotti": {
				ProdottoController controller = new ProdottoController(new ProdottoDAO());
				destination = controller.listaProdotti(request, response);
			}
				break;
			case "inseriscifornitore": {
				FornitoreController controller = new FornitoreController(new FornitoreDAO());
				destination = controller.inserisciFornitore(request, response);
			}
				break;
			case "mostraformaggiungifornitore": {		
				destination = new Destination("aggiungiFornitore.jsp", false);
			}
				break;
			case "mostraformupdatefornitore": {		
				FornitoreController controller = new FornitoreController(new FornitoreDAO());
				destination = controller.uploadFornitore(request, response);
			}
				break;
			case "updatefornitore": {		
				FornitoreController controller = new FornitoreController(new FornitoreDAO());
				destination = controller.updateFornitore(request, response);
			}
				break;
			case "cancellafornitore": {		
				FornitoreController controller = new FornitoreController(new FornitoreDAO());
				destination = controller.deleteFornitore(request, response);
			}
				break;
			case "mostraformaggiungiprodotto": {		
				destination = new Destination("aggiungiProdotto.jsp", false);
			}
				break;
			
			default: {
				BaseController controller = new BaseController();
				destination = controller.showErrorPageForMissingUrl(request, response);
			}

			}
		} catch (SQLException de) {
			request.setAttribute("EXCEPTION", de);
			destination = new Destination("ag.jsp", false);
		}
		if(destination.isRedirect()) {
			response.sendRedirect(destination.getUrl());
			
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(destination.getUrl());
			dispatcher.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
