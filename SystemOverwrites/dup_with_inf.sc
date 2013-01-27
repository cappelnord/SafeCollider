+ Function {
	dup { arg n = 2; // 3.6.2
		var array;
		SafeCollider.assert(n != inf, "Can't duplicate a value for infinite times!");
		^Array.fill(n, this)
	}
}

+ Object {
	dup { arg n = 2; // 3.6.2
		SafeCollider.assert(n != inf, "Can't duplicate a value for infinite times!");
		^Array.fill(n, { this.copy });
	}	
}