package com.fintech.model.conta;

public enum TipoConta implements TipoContaInterface {
	
	CONTA_CORRENTE {
		@Override
		public String get() {
			return "1";
		}
		
		@Override
		public String toString() {
			return "Conta corrente";
		}

	},
	
	CONTA_POUPANCA {
		@Override
		public String get() {
			return "2";
		}

		
		@Override
		public String toString() {
			return "Conta poupanca";
		}
		
	}

}
