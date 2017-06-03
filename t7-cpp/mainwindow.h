#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QPushButton>
#include <QMessageBox>
#include <QHBoxLayout>

namespace Ui {
class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QWidget *parent = 0);
    ~MainWindow();

public slots:
    void clickedSlot()
    {
        QMessageBox msgBox;
        msgBox.setWindowTitle("Hello");
        msgBox.setText("You Clicked "+ ((QPushButton*)sender())->text());
        msgBox.exec();
    }

private slots:
    void on_startButton_clicked();

private:
    Ui::MainWindow *ui;
};

#endif // MAINWINDOW_H
