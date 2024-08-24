package pruebadevsu.projectdevsu.api.service;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import pruebadevsu.projectdevsu.api.exception.ResourceNotFoundException;
import pruebadevsu.projectdevsu.api.model.Cliente;
import pruebadevsu.projectdevsu.api.model.Cuenta;
import pruebadevsu.projectdevsu.api.model.Movimiento;
import pruebadevsu.projectdevsu.api.repository.ClienteRepository;
import pruebadevsu.projectdevsu.api.repository.CuentaRepository;
import pruebadevsu.projectdevsu.api.repository.MovimientoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    public ByteArrayInputStream generarReporte(Long clienteId, Timestamp fechaInicio, Timestamp fechaFin) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + clienteId));

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            document.add(new Paragraph("Reporte de Movimientos"));
            document.add(new Paragraph("Cliente: " + cliente.getNombre()));
            document.add(new Paragraph("Rango de Fechas: " + fechaInicio + " - " + fechaFin));

            List<Cuenta> cuentas = cuentaRepository.findByClienteId(clienteId);
            for (Cuenta cuenta : cuentas) {
                document.add(new Paragraph("Cuenta: " + cuenta.getNumeroCuenta()));
                List<Movimiento> movimientos = movimientoRepository.findByCuentaIdAndFechaBetween(
                        cuenta.getId(), fechaInicio, fechaFin);

                for (Movimiento movimiento : movimientos) {
                    document.add(new Paragraph("Fecha: " + movimiento.getFecha() +
                            ", Tipo: " + movimiento.getTipoMovimiento() +
                            ", Valor: " + movimiento.getValor() +
                            ", Saldo: " + movimiento.getSaldo()));
                }
            }

            document.close();
        } catch (DocumentException e) {
            throw new RuntimeException("Error al generar el PDF: " + e.getMessage());
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}