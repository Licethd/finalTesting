package Dto.Tripulante;

import java.util.UUID;


import Model.Tripulante.Cargo;

public class TripulanteDto {
    public UUID Key;
    public String Nombre;
    public String Apellido;
    public String EmailAddress;
    public String Estado;
    public String Tipo;
    public Double HorasVuelo;


    public Double NroMillas;
    public Cargo Cargo;

    public TripulanteDto() {
    }

    public TripulanteDto(UUID key,String nombre, String apellido, String emailAddress,String estado,String tipo,Double horasVuelo, Double nroMillas,  Cargo cargo) {
        Key = key;
        Nombre = nombre;
        Apellido = apellido;
        EmailAddress = emailAddress;
        Estado = estado;
        Tipo = tipo;
		HorasVuelo = horasVuelo;
		NroMillas = nroMillas;
        Cargo = cargo;


    }


    public void setKey(UUID key) {
        this.Key = key;
    }

    public UUID getKey() {
        return Key;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

	public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Nombre = estado;
    }


    public Cargo getCargo() {
        return Cargo;
    }

    public void setCargo(Cargo cargo) {
        Cargo = cargo;
    }

	public String getTipo() {
		return this.Tipo;
	}

	public void setTipo(String tipo) {
		this.Tipo = tipo;
	}

	public Double getHorasVuelo() {
		return this.HorasVuelo;
	}

	public void setHorasVuelo(Double horasVuelo) {
		this.HorasVuelo = horasVuelo;
	}

	public Double getNroMillas() {
		return this.NroMillas;
	}

	public void setNroMillas(Double nroMillas) {
		this.NroMillas = nroMillas;
	}


}
