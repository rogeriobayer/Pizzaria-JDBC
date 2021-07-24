/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaria.controller;

import pizzaria.model.dao.ConnectionFactory;
import pizzaria.model.dao.ClienteDao;
import pizzaria.view.TelaCliente;

/**
 *
 * @author rafae
 */
public class Main {

    public static void main(String[] args) {
        TelaCliente view = new TelaCliente();
        ClienteDao modelDao = new ClienteDao(new ConnectionFactory());
        ClienteController controller = new ClienteController(view, modelDao);

    }

}
