/**
 * 
 */
package com.gluszecki.iocc.context;


/**
 * @author cthulhu
 *
 */
public enum BasicScope implements Scope {
	
	CONVERSATION {
		@Override
		public Context getContextInstance() {
			return ConversationContext.getInstance();
		}
	},
	
	GLOBAL {
		@Override
		public Context getContextInstance() {
			return GlobalContext.getInstance();
		}
	},
	
	SESSION {
		@Override
		public Context getContextInstance() {
			return SessionContext.getInstance();
		}
	},
	
	STATELESS {		
		@Override
		public Context getContextInstance() {
			return StatelessContext.getInstance();
		}
	},
	
	THREAD {
		@Override
		public Context getContextInstance() {
			// TODO Auto-generated method stub
			return null;
		}
	},
	
	UNSPECIFIED {	
		@Override
		public Context getContextInstance() {			
			return null;
		}
	}
}