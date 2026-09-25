package com.miapp.vista;

import com.miapp.controlador.EstudianteController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class EstudianteView extends JFrame {

    private static final int ANCHO_VENTANA = 1100;
    private static final int ALTO_VENTANA = 750;
    private static final int ANCHO_CAMPO_BUSQUEDA = 18;
    private static final int ANCHO_CAMPO_AGREGAR = 12;
    private static final int ALTO_FILA_TABLA = 24;

    private static final String TITULO_VENTANA = "Gestión de Estudiantes — MVC (Búsqueda + Agregar + Cursos + Profesores)";
    private static final String TITULO_PANEL_BUSQUEDA = "Buscar estudiante por nombre";
    private static final String TITULO_PANEL_CARRERA = "Buscar por carrera";
    private static final String TITULO_PANEL_AGREGAR = "Agregar nuevo estudiante";
    private static final String TITULO_PANEL_CURSOS = "Cursos: inscripción y consulta";
    private static final String TITULO_PANEL_PROFESORES = "Profesores: agregar y asignar a curso";
    private static final String TITULO_PANEL_ESTADO = "Estado de matrícula: buscar y cambiar";
    private static final String TITULO_PANEL_RESULTADOS = "Resultados";
    private static final String LABEL_NOMBRE = "Nombre:";
    private static final String LABEL_APELLIDO = "Apellido:";
    private static final String LABEL_CARRERA = "Carrera:";
    private static final String LABEL_PROMEDIO = "Promedio:";
    private static final String BOTON_BUSCAR = "Buscar";
    private static final String BOTON_BUSCAR_CARRERA = "Buscar por Carrera";
    private static final String BOTON_LIMPIAR = "Limpiar";
    private static final String BOTON_AGREGAR = "Agregar Estudiante";
    private static final String OPCION_SELECCIONAR = "Seleccionar...";
    private static final String MENSAJE_INICIAL = "Ingrese un nombre o seleccione una carrera y presione Buscar.";
    private static final String MENSAJE_ENCONTRADO_UNO = "Se encontró 1 estudiante.";
    private static final String MENSAJE_ENCONTRADOS_VARIOS = "Se encontraron {0} estudiante(s).";
    private static final String MENSAJE_SIN_RESULTADOS = "No se encontraron estudiantes con ese criterio.";

    private static final Color COLOR_BOTON_FONDO = new Color(59, 139, 212);
    private static final Color COLOR_BOTON_CARRERA = new Color(76, 175, 80);
    private static final Color COLOR_BOTON_LIMPIAR = new Color(244, 67, 54);
    private static final Color COLOR_BOTON_AGREGAR = new Color(103, 58, 183);
    private static final Color COLOR_BOTON_CURSOS = new Color(0, 150, 136);
    private static final Color COLOR_BOTON_INSCRIBIR = new Color(255, 152, 0);
    private static final Color COLOR_BOTON_PROFESOR = new Color(63, 81, 181);
    private static final Color COLOR_BOTON_ASIGNAR = new Color(33, 150, 243);
    private static final Color COLOR_BOTON_ESTADO = new Color(76, 175, 80);
    private static final Color COLOR_BOTON_CAMBIAR = new Color(0, 121, 107);
    private static final Color COLOR_BOTON_TEXTO = Color.WHITE;
    private static final Color COLOR_ESTADO_TEXTO = Color.GRAY;

    private static final String[] COLUMNAS_TABLA = {"ID", "Nombre", "Apellido", "Carrera", "Promedio", "Estado"};
    private static final int INDICE_PROMEDIO = 4;

    private JTextField             txtNombre;
    private JButton                btnBuscar;

    private JComboBox<String>      cmbCarrera;
    private JButton                btnBuscarCarrera;
    private JButton                btnLimpiar;

    private JTextField             txtAgregarNombre;
    private JTextField             txtAgregarApellido;
    private JComboBox<String>      cmbAgregarCarrera;
    private JSpinner               spinPromedio;
    private JButton                btnAgregar;

    private JComboBox<String>      cmbCurso;
    private JButton                btnVerEstudiantesCurso;
    private JButton                btnInscribirCurso;
    private JLabel                 lblProfesorAsignado;

    private JTextField             txtProfesorNombre;
    private JTextField             txtProfesorSalario;
    private JButton                btnAgregarProfesor;
    private JComboBox<String>      cmbProfesor;
    private JButton                btnVerCursosProfesor;
    private JComboBox<String>      cmbCursoAsignar;
    private JButton                btnAsignarCurso;

    private JComboBox<String>      cmbNuevoEstado;
    private JButton                btnBuscarEstado;
    private JButton                btnCambiarEstado;

    private JTable                 tblResultados;
    private DefaultTableModel      modeloTabla;
    private JLabel                 lblEstado;
    private JLabel                 lblTotalEstudiantes;

    private EstudianteController controlador;

    public EstudianteView() {
        initComponentes();
        initEventos();
    }

    private void initComponentes() {
        setTitle(TITULO_VENTANA);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(ANCHO_VENTANA, ALTO_VENTANA);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel panelBusqueda = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panelBusqueda.setBorder(BorderFactory.createTitledBorder(TITULO_PANEL_BUSQUEDA));

        JLabel lblNombre = new JLabel(LABEL_NOMBRE);
        txtNombre = new JTextField(ANCHO_CAMPO_BUSQUEDA);
        btnBuscar = new JButton(BOTON_BUSCAR);
        btnBuscar.setBackground(COLOR_BOTON_FONDO);
        btnBuscar.setForeground(COLOR_BOTON_TEXTO);
        btnBuscar.setFocusPainted(false);

        panelBusqueda.add(lblNombre);
        panelBusqueda.add(txtNombre);
        panelBusqueda.add(btnBuscar);

        JPanel panelCarrera = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panelCarrera.setBorder(BorderFactory.createTitledBorder(TITULO_PANEL_CARRERA));

        JLabel lblCarrera = new JLabel(LABEL_CARRERA);
        cmbCarrera = new JComboBox<>();
        cmbCarrera.addItem(OPCION_SELECCIONAR);

        btnBuscarCarrera = new JButton(BOTON_BUSCAR_CARRERA);
        btnBuscarCarrera.setBackground(COLOR_BOTON_CARRERA);
        btnBuscarCarrera.setForeground(COLOR_BOTON_TEXTO);
        btnBuscarCarrera.setFocusPainted(false);

        btnLimpiar = new JButton(BOTON_LIMPIAR);
        btnLimpiar.setBackground(COLOR_BOTON_LIMPIAR);
        btnLimpiar.setForeground(COLOR_BOTON_TEXTO);
        btnLimpiar.setFocusPainted(false);

        panelCarrera.add(lblCarrera);
        panelCarrera.add(cmbCarrera);
        panelCarrera.add(btnBuscarCarrera);
        panelCarrera.add(btnLimpiar);

        JPanel panelAgregar = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panelAgregar.setBorder(BorderFactory.createTitledBorder(TITULO_PANEL_AGREGAR));

        JLabel lblAgregarNombre = new JLabel(LABEL_NOMBRE);
        txtAgregarNombre = new JTextField(ANCHO_CAMPO_AGREGAR);

        JLabel lblAgregarApellido = new JLabel(LABEL_APELLIDO);
        txtAgregarApellido = new JTextField(ANCHO_CAMPO_AGREGAR);

        JLabel lblAgregarCarrera = new JLabel(LABEL_CARRERA);
        cmbAgregarCarrera = new JComboBox<>();
        cmbAgregarCarrera.addItem(OPCION_SELECCIONAR);

        JLabel lblAgregarPromedio = new JLabel(LABEL_PROMEDIO);
        spinPromedio = new JSpinner(new SpinnerNumberModel(3.0, 0.0, 5.0, 0.1));
        spinPromedio.setPreferredSize(new Dimension(60, 25));

        btnAgregar = new JButton(BOTON_AGREGAR);
        btnAgregar.setBackground(COLOR_BOTON_AGREGAR);
        btnAgregar.setForeground(COLOR_BOTON_TEXTO);
        btnAgregar.setFocusPainted(false);

        panelAgregar.add(lblAgregarNombre);
        panelAgregar.add(txtAgregarNombre);
        panelAgregar.add(lblAgregarApellido);
        panelAgregar.add(txtAgregarApellido);
        panelAgregar.add(lblAgregarCarrera);
        panelAgregar.add(cmbAgregarCarrera);
        panelAgregar.add(lblAgregarPromedio);
        panelAgregar.add(spinPromedio);
        panelAgregar.add(btnAgregar);

        JPanel panelCursos = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panelCursos.setBorder(BorderFactory.createTitledBorder(TITULO_PANEL_CURSOS));

        JLabel lblCurso = new JLabel("Curso:");
        cmbCurso = new JComboBox<>();
        cmbCurso.addItem("BDA100");
        cmbCurso.addItem("SIS101");

        btnVerEstudiantesCurso = new JButton("Ver estudiantes del curso");
        btnVerEstudiantesCurso.setBackground(COLOR_BOTON_CURSOS);
        btnVerEstudiantesCurso.setForeground(COLOR_BOTON_TEXTO);
        btnVerEstudiantesCurso.setFocusPainted(false);

        btnInscribirCurso = new JButton("Inscribir en curso");
        btnInscribirCurso.setBackground(COLOR_BOTON_INSCRIBIR);
        btnInscribirCurso.setForeground(COLOR_BOTON_TEXTO);
        btnInscribirCurso.setFocusPainted(false);

        lblProfesorAsignado = new JLabel("(primero busque y seleccione un estudiante en la tabla) Profesor asignado: (ninguno)");
        lblProfesorAsignado.setForeground(Color.DARK_GRAY);

        panelCursos.add(lblCurso);
        panelCursos.add(cmbCurso);
        panelCursos.add(btnVerEstudiantesCurso);
        panelCursos.add(btnInscribirCurso);
        panelCursos.add(lblProfesorAsignado);

        JPanel panelProfesores = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panelProfesores.setBorder(BorderFactory.createTitledBorder(TITULO_PANEL_PROFESORES));

        JLabel lblProfNombre = new JLabel("Nombre:");
        txtProfesorNombre = new JTextField(10);
        JLabel lblSalario = new JLabel("Salario base:");
        txtProfesorSalario = new JTextField("5.000.000", 8);

        btnAgregarProfesor = new JButton("Agregar Profesor");
        btnAgregarProfesor.setBackground(COLOR_BOTON_PROFESOR);
        btnAgregarProfesor.setForeground(COLOR_BOTON_TEXTO);
        btnAgregarProfesor.setFocusPainted(false);

        JLabel lblProfSelect = new JLabel("Profesor:");
        cmbProfesor = new JComboBox<>();
        cmbProfesor.addItem("Mg. Jorge Salcedo");

        btnVerCursosProfesor = new JButton("Ver cursos del profesor");
        btnVerCursosProfesor.setBackground(COLOR_BOTON_CURSOS);
        btnVerCursosProfesor.setForeground(COLOR_BOTON_TEXTO);
        btnVerCursosProfesor.setFocusPainted(false);

        JLabel lblAsignarC = new JLabel("Curso a asignar:");
        cmbCursoAsignar = new JComboBox<>();
        cmbCursoAsignar.addItem("SIS101");

        btnAsignarCurso = new JButton("Asignar a curso");
        btnAsignarCurso.setBackground(COLOR_BOTON_ASIGNAR);
        btnAsignarCurso.setForeground(COLOR_BOTON_TEXTO);
        btnAsignarCurso.setFocusPainted(false);

        panelProfesores.add(lblProfNombre);
        panelProfesores.add(txtProfesorNombre);
        panelProfesores.add(lblSalario);
        panelProfesores.add(txtProfesorSalario);
        panelProfesores.add(btnAgregarProfesor);
        panelProfesores.add(lblProfSelect);
        panelProfesores.add(cmbProfesor);
        panelProfesores.add(btnVerCursosProfesor);
        panelProfesores.add(lblAsignarC);
        panelProfesores.add(cmbCursoAsignar);
        panelProfesores.add(btnAsignarCurso);

        JPanel panelEstado = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panelEstado.setBorder(BorderFactory.createTitledBorder(TITULO_PANEL_ESTADO));

        JLabel lblNuevoEstado = new JLabel("Nuevo estado:");
        cmbNuevoEstado = new JComboBox<>();
        cmbNuevoEstado.addItem(OPCION_SELECCIONAR);
        cmbNuevoEstado.addItem("ACTIVO");
        cmbNuevoEstado.addItem("EGRESADO");
        cmbNuevoEstado.addItem("RETIRADO");

        btnBuscarEstado = new JButton("Buscar por estado");
        btnBuscarEstado.setBackground(COLOR_BOTON_ESTADO);
        btnBuscarEstado.setForeground(COLOR_BOTON_TEXTO);
        btnBuscarEstado.setFocusPainted(false);

        btnCambiarEstado = new JButton("Cambiar estado");
        btnCambiarEstado.setBackground(COLOR_BOTON_CAMBIAR);
        btnCambiarEstado.setForeground(COLOR_BOTON_TEXTO);
        btnCambiarEstado.setFocusPainted(false);

        JLabel lblNotaEstado = new JLabel("(\"Cambiar estado\" requiere seleccionar un estudiante en la tabla)");
        lblNotaEstado.setForeground(Color.DARK_GRAY);

        panelEstado.add(lblNuevoEstado);
        panelEstado.add(cmbNuevoEstado);
        panelEstado.add(btnBuscarEstado);
        panelEstado.add(btnCambiarEstado);
        panelEstado.add(lblNotaEstado);

        JPanel panelSuperior = new JPanel(new GridLayout(6, 1, 2, 2));
        panelSuperior.add(panelBusqueda);
        panelSuperior.add(panelCarrera);
        panelSuperior.add(panelAgregar);
        panelSuperior.add(panelCursos);
        panelSuperior.add(panelProfesores);
        panelSuperior.add(panelEstado);

        modeloTabla = new DefaultTableModel(COLUMNAS_TABLA, 0) {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };
        tblResultados = new JTable(modeloTabla);
        tblResultados.setRowHeight(ALTO_FILA_TABLA);
        tblResultados.getTableHeader().setReorderingAllowed(false);
        tblResultados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scroll = new JScrollPane(tblResultados);
        scroll.setBorder(BorderFactory.createTitledBorder(TITULO_PANEL_RESULTADOS));

        JPanel panelInferior = new JPanel(new BorderLayout(10, 10));

        lblEstado = new JLabel(MENSAJE_INICIAL);
        lblEstado.setBorder(BorderFactory.createEmptyBorder(4, 10, 4, 10));
        lblEstado.setForeground(COLOR_ESTADO_TEXTO);

        lblTotalEstudiantes = new JLabel();
        lblTotalEstudiantes.setBorder(BorderFactory.createEmptyBorder(4, 10, 4, 10));
        lblTotalEstudiantes.setForeground(Color.BLUE);
        actualizarTotalEstudiantes();

        panelInferior.add(lblEstado, BorderLayout.WEST);
        panelInferior.add(lblTotalEstudiantes, BorderLayout.EAST);

        add(panelSuperior,    BorderLayout.NORTH);
        add(scroll,            BorderLayout.CENTER);
        add(panelInferior,    BorderLayout.SOUTH);
    }

    private void cargarCarreras() {
        if (controlador != null) {
            String[] carreras = controlador.obtenerCarrerasUnicas();
            for (String carrera : carreras) {
                cmbCarrera.addItem(carrera);
            }
        }
    }

    private void cargarCarrerasAgregar() {
        if (controlador != null) {
            String[] carreras = controlador.obtenerCarrerasUnicas();
            for (String carrera : carreras) {
                cmbAgregarCarrera.addItem(carrera);
            }
        }
    }

    private void initEventos() {
        btnBuscar.addActionListener((ActionEvent e) -> {
            if (controlador != null) {
                controlador.buscarEstudiante(txtNombre.getText().trim());
            }
        });

        txtNombre.addActionListener((ActionEvent e) -> btnBuscar.doClick());

        btnBuscarCarrera.addActionListener((ActionEvent e) -> {
            if (controlador != null) {
                String carriSelected = (String) cmbCarrera.getSelectedItem();
                if (carriSelected != null && !carriSelected.equals(OPCION_SELECCIONAR)) {
                    controlador.buscarEstudiantePorCarrera(carriSelected);
                } else {
                    mostrarError("Seleccione una carrera válida.");
                }
            }
        });

        btnLimpiar.addActionListener((ActionEvent e) -> {
            limpiarBusqueda();
        });

        btnAgregar.addActionListener((ActionEvent e) -> {
            if (controlador != null) {
                String nombre = txtAgregarNombre.getText().trim();
                String apellido = txtAgregarApellido.getText().trim();
                String carrera = (String) cmbAgregarCarrera.getSelectedItem();
                double promedio = (double) spinPromedio.getValue();

                if (controlador.agregarEstudiante(nombre, apellido, carrera, promedio)) {
                    txtAgregarNombre.setText("");
                    txtAgregarApellido.setText("");
                    cmbAgregarCarrera.setSelectedIndex(0);
                    spinPromedio.setValue(3.0);
                    actualizarTotalEstudiantes();
                }
            }
        });

        btnBuscarEstado.addActionListener((ActionEvent e) -> {
            if (controlador != null) {
                String estadoSelected = (String) cmbNuevoEstado.getSelectedItem();
                if (estadoSelected != null && !estadoSelected.equals(OPCION_SELECCIONAR)) {
                    controlador.buscarEstudiantesPorEstado(estadoSelected);
                } else {
                    mostrarError("Seleccione un estado de matrícula válido.");
                }
            }
        });

        btnVerEstudiantesCurso.addActionListener((ActionEvent e) -> {
            if (controlador != null) {
                String cursoSelected = (String) cmbCurso.getSelectedItem();
                controlador.buscarEsdutidantesPorCurso(cursoSelected);
            }
        });
    }

    public void mostrarEstudiante(Object[] fila) {
        limpiarTabla();
        modeloTabla.addRow(fila);
        setEstado(MENSAJE_ENCONTRADO_UNO);
    }

    public void mostrarEstudiantes(List<Object[]> filas) {
        limpiarTabla();
        if (filas == null || filas.isEmpty()) {
            setEstado(MENSAJE_SIN_RESULTADOS);
            return;
        }
        for (Object[] fila : filas) {
            modeloTabla.addRow(fila);
        }
        setEstado(String.format(MENSAJE_ENCONTRADOS_VARIOS, filas.size()));
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        setEstado("Error: " + mensaje);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
        setEstado(mensaje);
    }

    public String getNombreBuscado() {
        return txtNombre.getText().trim();
    }

    public void setControlador(EstudianteController controlador) {
        this.controlador = controlador;
        cargarCarreras();
        cargarCarrerasAgregar();
        actualizarTotalEstudiantes();
    }

    private void actualizarTotalEstudiantes() {
        int total = (controlador != null) ? controlador.obtenerTotalEstudiantes() : 0;
        lblTotalEstudiantes.setText("Total de estudiantes: " + total);
    }

    private void limpiarBusqueda() {
        txtNombre.setText("");
        cmbCarrera.setSelectedIndex(0);
        limpiarTabla();
        setEstado(MENSAJE_INICIAL);
    }

    private void limpiarTabla() {
        modeloTabla.setRowCount(0);
    }

    private void setEstado(String texto) {
        lblEstado.setText(texto);
    }
}