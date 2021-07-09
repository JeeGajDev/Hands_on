package observer;

import java.io.File;

public class Editor {

	public EventManager events;
    private File file;

    public Editor() {
        this.events = new EventManager("open", "save");
    }
    
    public void openFile(String filePath) {
        this.file = new File(filePath);
        events.notify("open", file);
    }
    
    public void saveFile() throws Exception {
        if (this.file != null) {
            events.notify("save", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }
    
    public class  Producer extends Thread {
		Producer() {
			super("Producer");
		}
 
		@Override
		public void run() {
			for (;;) {
				try {
					Thread.sleep(1000);
					System.out.println("Object Produced ~~~~~~~~~~~~~~~");
				} catch (Exception e) {
					e.printStackTrace();
				}
//				data.add(new Object());
//				if (data.size() > 1000)
//					data.remove(data.size() - 1);
			}
		}
	}
}
