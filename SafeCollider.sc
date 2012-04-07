SafeCollider {
	*assert {|assertion, message|
		assertion.not.if {
			SafeCollider.error(message);	
		}
	}
	
	*error {|message|
		("SafeCollider: " ++ message).throw;	
	}
}