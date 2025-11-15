public class Main {
    public static void main(String[] args) {

        EmpresaTIA1945 miEmpresa = new EmpresaTIA1945();

        GerenteVazquez gerente = new GerenteVazquez("Alberto", 1, 80000, 15000);
        DesarrolladorVazquez dev = new DesarrolladorVazquez("Ana", 10, 50000, "Java");
        VendedorVazquez vendedor = new VendedorVazquez("Juan", 20, 30000, 0.10);

        // El vendedor hace ventas
        vendedor.registrarVenta(100000); // 100k * 10% = 10k de bono

        System.out.println("Contratando personal...");
        miEmpresa.contratarEmpleado(gerente);
        miEmpresa.contratarEmpleado(dev);
        miEmpresa.contratarEmpleado(vendedor);

        miEmpresa.mostrarNomina();
    }
}