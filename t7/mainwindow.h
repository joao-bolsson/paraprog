#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QPushButton>
#include <QMessageBox>
#include <QHBoxLayout>

#include <string>

using namespace std;
namespace Ui {
class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QWidget *parent = 0);
    ~MainWindow();

    int winners;

private slots:
    void on_startButton_clicked();

    void start(bool flag);

    void on_resetButton_clicked();

    void on_sortButton_clicked();

    void showMessage(string text);

private:
    Ui::MainWindow *ui;
};

#endif // MAINWINDOW_H
