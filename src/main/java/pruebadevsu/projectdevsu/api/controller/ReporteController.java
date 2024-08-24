package pruebadevsu.projectdevsu.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pruebadevsu.projectdevsu.api.service.ReporteService;

import java.io.ByteArrayInputStream;
import java.sql.Timestamp;

@RestController
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/reportes")
    public ResponseEntity<InputStreamResource> generarReporte(
            @RequestParam Long clienteId,
            @RequestParam Timestamp fechaInicio,
            @RequestParam Timestamp fechaFin) {

        ByteArrayInputStream bis = reporteService.generarReporte(clienteId, fechaInicio, fechaFin);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=reporte.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}