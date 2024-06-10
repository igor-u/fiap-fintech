package com.fintech.model.usuario;

public enum TipoUsuario implements TipoUsuarioInterface {
	
	USUARIO_PESSOA {
		@Override
		public String get() {
			return "1";
		}
		
		@Override
		public String toString() {
			return "Pessoa";
		}

	},
	
	USUARIO_EMPRESA {
		@Override
		public String get() {
			return "2";
		}

		
		@Override
		public String toString() {
			return "Empresa";
		}
		
	}

}
