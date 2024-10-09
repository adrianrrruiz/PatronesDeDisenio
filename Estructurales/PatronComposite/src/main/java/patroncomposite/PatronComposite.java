/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Composite
 * Tipo de Clase: Main()
 */
package patroncomposite;
import java.util.Random;
import composicion.productos.ConfiguracionCompuestaProducto;
import composicion.productos.ConfiguracionSimpleProducto;
import composicion.ordenes.OrdenVenta;

/**
 *
 * @author Fabrizio Bolaño
 */
public class PatronComposite {
    private final Random random = new Random();

    private ConfiguracionSimpleProducto ram4gb;
    private ConfiguracionSimpleProducto ram8gb;
    private ConfiguracionSimpleProducto disk500gb;
    private ConfiguracionSimpleProducto disk1tb;
    private ConfiguracionSimpleProducto cpuAMD;
    private ConfiguracionSimpleProducto cpuIntel;
    private ConfiguracionSimpleProducto smallCabinete;
    private ConfiguracionSimpleProducto bigCabinete;
    private ConfiguracionSimpleProducto monitor20inch;
    private ConfiguracionSimpleProducto monitor30inch;
    private ConfiguracionSimpleProducto simpleMouse;
    private ConfiguracionSimpleProducto gammerMouse;

    private ConfiguracionCompuestaProducto gammerPC;
    private ConfiguracionCompuestaProducto homePC;
    private ConfiguracionCompuestaProducto pc2x1;

    private ConfiguracionSimpleProducto descuento;

    private void CreardProductos() {
        //Configuraciòn de productos simples
        ram4gb = new ConfiguracionSimpleProducto("RAM 4GB", 750, "KingStone", 0.16, 2);
        ram8gb = new ConfiguracionSimpleProducto("RAM 8GB", 1000, "KingStone", 0.12, 3);
        disk500gb = new ConfiguracionSimpleProducto("HDD 500GB", 1500, "ACME", 0.14, 1);
        disk1tb = new ConfiguracionSimpleProducto("HDD 1TB", 2000, "ACME", 0.15, 2);
        cpuAMD = new ConfiguracionSimpleProducto("AMD phenon", 4000, "AMD", 0.18, 1);
        cpuIntel = new ConfiguracionSimpleProducto("Intel i7", 4500, "Intel", 0.17, 2);
        smallCabinete = new ConfiguracionSimpleProducto("Small cabinet", 2000, "ExCom", 0.10, 1);
        bigCabinete = new ConfiguracionSimpleProducto("Big Cabinet", 2200, "ExCom", 0.13, 2);
        monitor20inch = new ConfiguracionSimpleProducto("Display 20'", 1500, "HP", 0.16, 1);
        monitor30inch = new ConfiguracionSimpleProducto("Display 30'", 2000, "HP", 0.14, 2);
        simpleMouse = new ConfiguracionSimpleProducto("Simple mouse", 150, "Genius", 0.08, 5);
        gammerMouse = new ConfiguracionSimpleProducto("Gammer mouse", 750, "Alien", 0.20, 3);
        descuento = new ConfiguracionSimpleProducto("Descuento", -500, "Descuento", 0.0, 1);

        //Producto Compuesto con: Gammer pc de 8gb ram,HDD 1tb, Intel i7 processor
        //large cabinet,display 30' y one gammer mouse.
        gammerPC = new ConfiguracionCompuestaProducto("Gammer PC");
        gammerPC.AgregarProducto(ram8gb);
        gammerPC.AgregarProducto(disk1tb);
        gammerPC.AgregarProducto(cpuIntel);
        gammerPC.AgregarProducto(bigCabinete);
        gammerPC.AgregarProducto(monitor30inch);
        gammerPC.AgregarProducto(gammerMouse);

        //Paquete: Home PC con RAM 4gb, HDD 500gb, AMD Phenon processor
        //small Cabinet, dsplay 20' y simple mouse.
        homePC = new ConfiguracionCompuestaProducto("Home PC");
        homePC.AgregarProducto(ram4gb);//
        homePC.AgregarProducto(disk500gb);
        homePC.AgregarProducto(cpuAMD);
        homePC.AgregarProducto(smallCabinete);
        homePC.AgregarProducto(monitor20inch);
        homePC.AgregarProducto(simpleMouse);
        //RETO: Agregar un descuento con un precio negativo al Home PC
        homePC.AgregarProducto(descuento);

        //Combo confirmado por 2 paquetes, Gammer PC + Home PC
        pc2x1 = new ConfiguracionCompuestaProducto("Pack PC Gammer + Home PC");
        pc2x1.AgregarProducto(gammerPC);
        pc2x1.AgregarProducto(homePC);
    }

    private void OrdenVentaParaConfiguracionSimpleProducto() {

        OrdenVenta OrdenConfiguracionSimple = new OrdenVenta(random.nextInt(), "Hector Lavoe");
        OrdenConfiguracionSimple.AgregarProducto(ram4gb);
        OrdenConfiguracionSimple.AgregarProducto(disk1tb);
        OrdenConfiguracionSimple.AgregarProducto(simpleMouse);
        OrdenConfiguracionSimple.ImprimirOrdenVenta();
    }

    private void OrdenVentaGammerPC() {
        OrdenVenta gammerOrdenVenta = new OrdenVenta(1, "Ismael Rivera");
        gammerOrdenVenta.AgregarProducto(gammerPC);
        gammerOrdenVenta.ImprimirOrdenVenta();
    }

    private void OrdenVentaHomePC() {
        OrdenVenta homeOrdenVenta = new OrdenVenta(2, "Celia Cruz");
        homeOrdenVenta.AgregarProducto(homePC);
        homeOrdenVenta.ImprimirOrdenVenta();
    }
    private void OrdenVentaCombo() {
        OrdenVenta comboOrdenVenta = new OrdenVenta(3, "Paquete 2x1 en PC");
        comboOrdenVenta.AgregarProducto(pc2x1);
        comboOrdenVenta.ImprimirOrdenVenta();
    }

    private void OrdenVentaMega() {
        OrdenVenta OrdenVentaPersonalizada = new OrdenVenta(4, "Tito Nieves");
        OrdenVentaPersonalizada.AgregarProducto(homePC);
        OrdenVentaPersonalizada.AgregarProducto(ram8gb);
        OrdenVentaPersonalizada.AgregarProducto(ram4gb);
        OrdenVentaPersonalizada.AgregarProducto(monitor30inch);
        OrdenVentaPersonalizada.AgregarProducto(gammerMouse);
        OrdenVentaPersonalizada.AgregarProducto(descuento); //RETO
        OrdenVentaPersonalizada.ImprimirOrdenVenta();
    }

    public static void main(String[] args) {
        PatronComposite main = new PatronComposite();
        main.CreardProductos();

        // main.OrdenVentaParaConfiguracionSimpleProducto();
        main.OrdenVentaHomePC();
        // main.OrdenVentaGammerPC();
        //main.OrdenVentaCombo();
        main.OrdenVentaMega();


    }

}