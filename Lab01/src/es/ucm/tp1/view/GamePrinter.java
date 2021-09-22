package es.ucm.tp1.view;

import es.ucm.tp1.utils.StringUtils;
import es.ucm.tp1.logic.Game;

public class GamePrinter {

	private static final String SPACE = " ";

	private static final String ROAD_BORDER_PATTERN = "═";

	private static final String LANE_DELIMITER_PATTERN = "─";

	private static final int CELL_SIZE = 7;

	private static final int MARGIN_SIZE = 2;

	private Game game;

	private int numRows;

	private int numCols;

	private String indentedRoadBorder;

	private String indentedLlanesSeparator;

	private String margin;

	private String[][] board;
	
	public GamePrinter(Game game, int cols, int rows) {
		this.game = game;
		this.numRows = rows;
		this.numCols = cols;

		this.margin = StringUtils.repeat(SPACE, MARGIN_SIZE);

		String roadBorder = ROAD_BORDER_PATTERN + StringUtils.repeat(ROAD_BORDER_PATTERN, (CELL_SIZE + 1) * numCols);
		this.indentedRoadBorder = String.format("%n%s%s%n", margin, roadBorder);

		String laneDelimiter = StringUtils.repeat(LANE_DELIMITER_PATTERN, CELL_SIZE);
		String lanesSeparator = SPACE + StringUtils.repeat(laneDelimiter + SPACE, numCols - 1) + laneDelimiter + SPACE;

		this.indentedLlanesSeparator = String.format("%n%s%s%n", margin, lanesSeparator);

	}

	private void encodeGame(Game game) {
		// TODO fill your code
	}

	@Override
	public String toString() {
		encodeGame(game);
		
		StringBuilder str = new StringBuilder();

		// Game Status
		str.append(game.getGameStatus());

		// Paint game

		str.append(indentedRoadBorder);

		String verticalDelimiter = SPACE;

		for (int y = 0; y < numRows; y++) {
			str.append(this.margin).append(verticalDelimiter);
			for (int x = 0; x < numCols; x++) {
				str.append(StringUtils.centre(board[y][x], CELL_SIZE))
						.append(verticalDelimiter);
			}
			if (y < numRows - 1) {
				str.append(this.indentedLlanesSeparator);
			}
		}
		str.append(this.indentedRoadBorder);

		return str.toString();
	}
}
