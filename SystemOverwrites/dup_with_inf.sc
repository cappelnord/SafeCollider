+ Function {
	dup { arg n = 2; // 3.5.1
		var array;
		SafeCollider.assert(n != inf, "Can't duplicate a value for infinite times!");
		array = Array(n);
		n.do {|i| array.add(this.value(i)) };
		^array
	}
}

+ Object {
	dup { arg n = 2; // 3.5.1
		SafeCollider.assert(n != inf, "Can't duplicate a value for infinite times!");
		^Array.fill(n, { this.copy });
	}	
}