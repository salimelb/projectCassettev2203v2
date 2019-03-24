package Class_Diagram_CassetteDeck.UI;

public interface CassetteDeck_Active {

	int curState = CassetteDeck_Active.attribute;
	int attribute = CassetteDeck_Active.curState;

	void OpenFailPanel();

}